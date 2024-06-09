import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Model.GameState;
import Model.IGameView;
import Rules.ChessMove;
import Model.Piece;
import Model.Player;
import Rules.Rules;

import java.awt.*;
import java.awt.event.*;

import Pieces.ComputerPlayer;
import Pieces.HumanPlayer;
import Pieces.PiecePosition;




public class Board implements MouseListener, MouseMotionListener{

    private static final int BOARD_LENGTH = BoardPanel.PANEL_LENGTH*BoardPanel.SQUARE_LENGTH;
    private JFrame frame = new JFrame();
    private JPanel panel;

    private IGameView gameView;
    private GameState gameState;

    private ChessMove chessMove;
    public List<ChessMove> moves;

    private HumanPlayer player1 = new HumanPlayer(true);
    private HumanPlayer player2 = new HumanPlayer(false);


    PiecePosition firstClickPiecePos = null;
    boolean firstClick = true;

    public Board(IGameView gameView, GameState gameState) throws IOException {
        this.gameView = gameView;
        this.gameState = gameState;
        this.moves = new ArrayList<>();

        frame = new JFrame();
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
        frame.setUndecorated(false);

        panel = new BoardPanel(gameView);
        frame.setBounds(10, 10, BOARD_LENGTH, BOARD_LENGTH);
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    public void mouseDragged(MouseEvent e) {
        // System.out.println("You have DRAGGED the mouse");
    }

    public void mouseMoved(MouseEvent e) {
        // System.out.println("You have MOVED the mouse");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        final Point pos = e.getPoint();
        final PiecePosition clickPiecePos = convertToPiecePosition(GraphicsPosition.create(pos.y, pos.x));
        printPieceAtPosition(gameState.getPieces(), clickPiecePos); 

        if (firstClick == true) {
            firstClickPiecePos = clickPiecePos;
            Piece pieceToMove = gameState.getPieceAtPiecePosition(firstClickPiecePos);
            firstClick = pieceToMove == null ? true : false;

        } else {
            PiecePosition secondClickPiecePos = clickPiecePos;
            ChessMove chessMove = new ChessMove(firstClickPiecePos, secondClickPiecePos, player1);

            System.out.println("moves.size(): " + moves.size());

            if (moves.size() == 0) {
                chessMove = new ChessMove(firstClickPiecePos, secondClickPiecePos, player1);
            }
            else{
                
                ChessMove lastMove = moves.get(moves.size() - 1);
                System.out.println("lastMove: " + lastMove);
                Player lastMovePlayer = lastMove.getPlayer();
                System.out.println("lastMovePlayer.iswhite(): " + lastMovePlayer.isWhite());
                System.out.println("lastMovePlayer.isWhite() == player1.isWhite(): " + (lastMovePlayer.isWhite() == player1.isWhite()));

                if (lastMovePlayer.isWhite() == player1.isWhite()) {
                    System.out.println("hello");
                    chessMove = new ChessMove(firstClickPiecePos, secondClickPiecePos, player2);
                }
                else {
                    System.out.println("goodbye");
                    chessMove = new ChessMove(firstClickPiecePos, secondClickPiecePos, player1);
                }

            }
            
            
            if (Rules.isLegalMove(chessMove, gameState)) {
                System.out.println("Move is legal");
                movePiece(chessMove, gameView, gameState, panel);
                moves.add(chessMove);
            }
            else {
                System.out.println("Move is not legal");
            }

            firstClick = true;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse has ENTERED the panel.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse has EXITED the panel.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("You have RELEASED the mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("You have PRESSED the mouse");
    }

    private static PiecePosition convertToPiecePosition(GraphicsPosition pos){
        return new PiecePosition(scaleCoordinate(pos.getRow(), true), scaleCoordinate(pos.getCol(), false));
    }
    
    private static int scaleCoordinate(int coord, boolean isRow) {

        if (isRow) {
            return (int) (coord-30)/BoardPanel.SQUARE_LENGTH;
        }
        else {
            return (int) (coord/BoardPanel.SQUARE_LENGTH);
        }
    }

    private static void printPieceAtPosition(List<Piece> pieces, PiecePosition clickPiecePos) {
        boolean pieceHere = false;
        for (Piece piece: pieces){
            PiecePosition piecePos = piece.getPos();
            String colour = piece.isWhite() ? "White" : "Black";
            if (piecePos.getRow() == clickPiecePos.getRow() & piecePos.getCol() == clickPiecePos.getCol()) {
                System.out.println("There is a " + colour +" "+ piece.getPieceType() + " here");
                pieceHere = true;
                break;
            }
        }
        if (!pieceHere) {
            System.out.println("There is no piece here");
        }
    }

    public void movePiece(ChessMove move, IGameView gameView, GameState c, JPanel panel) {
        
        PiecePosition startPiecePos = move.getStartPiecePosition();
        PiecePosition endPiecePos = move.getEndPiecePosition();

        List<Piece> viewPieces = gameView.getPieces();
        List<Piece> statePieces = gameState.getPieces();

        Piece viewPieceToMove = gameView.getPieceAtPiecePosition(startPiecePos);
        Piece statePieceToMove = gameState.getPieceAtPiecePosition(startPiecePos);

        Piece viewPieceAtFinalSquare = gameView.getPieceAtPiecePosition(endPiecePos);
        Piece statePieceAtFinalSquare = gameState.getPieceAtPiecePosition(endPiecePos);

        viewPieceToMove.setPos(endPiecePos);
        statePieceToMove.setPos(endPiecePos);

        if (statePieceAtFinalSquare != null) {

            viewPieces.remove(viewPieceAtFinalSquare);
            statePieces.remove(statePieceAtFinalSquare);

            gameView.setPieces(viewPieces);
            gameState.setPieces(statePieces);
        }

        viewPieceToMove.setHasMoved(true);
        statePieceToMove.setHasMoved(true); 

        panel.repaint();
        
    }

    public static void killPieceAtPosition(IGameView gameView, PiecePosition clickPiecePos, JPanel panel) {
        boolean pieceHere = false;
        List<Piece> pieces = gameView.getPieces();
        for (Piece piece: pieces){
            PiecePosition piecePos = piece.getPos();
            String colour = piece.isWhite() ? "White" : "Black";
            if (piecePos.getRow() == clickPiecePos.getRow() & piecePos.getCol() == clickPiecePos.getCol()) {
                System.out.println("There is a " + colour +" "+ piece.getPieceType() + " here");
                pieceHere = true;
                pieces.remove(piece);
                gameView.setPieces(pieces);
                panel.repaint();
                break;
            }
        }
        if (!pieceHere) {
            System.out.println("There is no piece here");
        }
    }

    

}

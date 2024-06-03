import java.io.IOException;
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
    private HumanPlayer player1 = new HumanPlayer(true);
    private ComputerPlayer player2;
    PiecePosition firstClickPiecePos = null;
    boolean firstClick = true;
    // Container pane = frame.getContentPane();

    public Board(IGameView gameView, GameState gameState) throws IOException {
        this.gameView = gameView;
        this.gameState = gameState;

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
            firstClick = false;

        } else {
            PiecePosition secondClickPiecePos = clickPiecePos;
            ChessMove chessMove = new ChessMove(firstClickPiecePos, secondClickPiecePos, player1);
            if (Rules.isLegalMove(chessMove, gameState)) {
                System.out.println("Move is legal");
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

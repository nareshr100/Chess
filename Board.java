import java.io.IOException;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Pieces.IGameView;
import Pieces.Piece;
import Pieces.PiecePosition;



public class Board implements MouseListener, MouseMotionListener{

    private static final int BOARD_LENGTH = BoardPanel.PANEL_LENGTH*BoardPanel.SQUARE_LENGTH;
    private JFrame frame = new JFrame();
    private JPanel panel;
    private IGameView gameView;
    // Container pane = frame.getContentPane();

    public Board(IGameView gameView) throws IOException {
        this.gameView = gameView;

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
        List<Piece> pieces = gameView.getPieces();
        printPieceAtPosition(pieces, clickPiecePos);
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
}

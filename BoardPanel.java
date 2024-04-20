import java.awt.Graphics;
import java.io.IOException;
import java.util.List;

import javax.swing.JPanel;

import Pieces.IGameView;
import Pieces.Piece;
import Pieces.PiecePosition;
import java.awt.Image;
import Pieces.Piece;
import Pieces.PiecePosition;

import java.awt.Graphics;
import java.awt.Color;

final class BoardPanel extends JPanel {

    private static final Color BLACK_COLOUR = new Color(119, 148, 85);
    private static final Color WHITE_COLOUR = new Color(235, 235, 208);
    public static final int PANEL_LENGTH = 8;
    public static final int SQUARE_LENGTH = 64;

    private final IGameView gameView;
    private final Theme theme = new Theme();

    BoardPanel(IGameView gameView) throws IOException {
        this.gameView = gameView;
    }

    @Override
    public void paint(Graphics graphics) {
        boolean white = true;

        for (int col = 0; col < PANEL_LENGTH; col++) {

            for (int row = 0; row < PANEL_LENGTH; row++) {
                if (white) {
                    graphics.setColor(WHITE_COLOUR);
                } else {
                    graphics.setColor(BLACK_COLOUR);

                }
                graphics.fillRect(row * SQUARE_LENGTH, col * SQUARE_LENGTH, SQUARE_LENGTH, SQUARE_LENGTH);
                white = !white;
            }
            white = !white;
        }

        addPieces(gameView.getPieces(), graphics);
    }

    private void addPieces(List<Piece> pieces, Graphics graphics) {
        
        for (Piece piece : pieces) {
            placePiece(piece, graphics);
        }
    }

    public void placePiece(Piece piece, Graphics graphics){
        GraphicsPosition graphicsPos = convertToGraphicsPosition(piece.getPos());
        Image img = this.theme.getPieceImage(piece);
        graphics.drawImage(img, graphicsPos.getCol(), graphicsPos.getRow(), this);
    }

    private static GraphicsPosition convertToGraphicsPosition(PiecePosition pos){
        return new GraphicsPosition(scaleCoordinate(pos.getRow()), scaleCoordinate(pos.getCol()));
    }

    private static int scaleCoordinate(int coord) {
        return (int) ((coord)*SQUARE_LENGTH);
    }

}
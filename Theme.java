import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import Model.Piece;
import Pieces.PieceType;

public class Theme {

    private Map<PieceType, Image> bImages = new EnumMap<>(PieceType.class);
    private Map<PieceType, Image> wImages = new EnumMap<>(PieceType.class);

    public Theme() throws IOException {
        BufferedImage all = ImageIO.read(new File("chess.png"));
        extractSubImages(all, wImages, 0);
        extractSubImages(all, bImages, 1);
    }

    private void extractSubImages(BufferedImage all, Map<PieceType, Image> images, int row) {
        images.put(PieceType.KING, extractSubImage(all, row, 0));
        images.put(PieceType.QUEEN, extractSubImage(all, row, 1));
        images.put(PieceType.BISHOP, extractSubImage(all, row, 2));
        images.put(PieceType.KNIGHT, extractSubImage(all, row, 3));
        images.put(PieceType.ROOK, extractSubImage(all, row, 4));
        images.put(PieceType.PAWN, extractSubImage(all, row, 5));
    }

    private Image extractSubImage(BufferedImage all, int row, int col) {
        return all.getSubimage(col*200, row*200, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
    }

    public Image getPieceImage(Piece piece) {
        return piece.isWhite() ? this.wImages.get(piece.getPieceType()) : this.bImages.get(piece.getPieceType());
    }
}

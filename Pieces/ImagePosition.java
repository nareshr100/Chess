package Pieces;

public class ImagePosition extends Position{

    public ImagePosition(int xp, int yp) {
        super(xp, yp);
    }

    public static ImagePosition create(int xp, int yp) {
        return new ImagePosition(xp, yp);
    }

}

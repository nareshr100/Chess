import Pieces.Position;

public class GraphicsPosition extends Position{

    public GraphicsPosition(int row, int ycol) {
        super(row, ycol);
    }

    public static GraphicsPosition create(int row, int col) {
        return new GraphicsPosition(row, col);
    }

}

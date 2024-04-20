package Pieces;

public class PiecePosition extends Position{

    public PiecePosition(int row, int col) {
        super(row, col);
    }

    public static PiecePosition create(int row, int col) {
        return new PiecePosition(row, col);
    }

}

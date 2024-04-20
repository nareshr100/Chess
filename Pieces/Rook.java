package Pieces;

public class Rook extends Piece{

    private Rook(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.ROOK);
    }
    
    public static Rook create(PiecePosition pos, boolean isWhite){
        return new Rook(pos, isWhite);
    }

}

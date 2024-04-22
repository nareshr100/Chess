package Pieces;

public class King extends Piece {
    
    private King(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.KING);
    }
    
    public static King create(PiecePosition pos, boolean isWhite){
        return new King(pos, isWhite);
    }

}

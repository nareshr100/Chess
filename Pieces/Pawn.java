package Pieces;

public class Pawn extends Piece {
    
    private Pawn(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.PAWN);
    }
    
    public static Pawn create(PiecePosition pos, boolean isWhite){
        return new Pawn(pos, isWhite);
    }

}
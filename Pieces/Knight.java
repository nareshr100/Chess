package Pieces;

public class Knight extends Piece {
    
    private Knight(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.KNIGHT);
    }
    
    public static Knight create(PiecePosition pos, boolean isWhite){
        return new Knight(pos, isWhite);
    }

}
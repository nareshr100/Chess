package Pieces;

public class Bishop extends Piece {
    
    private Bishop(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.BISHOP);
    }
    
    public static Bishop create(PiecePosition pos, boolean isWhite){
        return new Bishop(pos, isWhite);
    }

}
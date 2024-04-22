package Pieces;

public class Queen extends Piece {
    
    private Queen(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.QUEEN);
    }
    
    public static Queen create(PiecePosition pos, boolean isWhite){
        return new Queen(pos, isWhite);
    }

}

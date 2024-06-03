package Pieces;

import Model.Piece;
import Rules.ChessMove;

public class Bishop extends Piece {
    
    private Bishop(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.BISHOP, false);
    }
    
    public static Bishop create(PiecePosition pos, boolean isWhite){
        return new Bishop(pos, isWhite);
    }

    @Override
    public boolean isValidMove(ChessMove move) {
        return true;
    }

}
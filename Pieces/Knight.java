package Pieces;

import Model.Move;
import Model.Piece;
import Rules.ChessMove;

public class Knight extends Piece {
    
    private Knight(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.KNIGHT, false);
    }
    
    public static Knight create(PiecePosition pos, boolean isWhite){
        return new Knight(pos, isWhite);
    }

    @Override
    public boolean isValidMove(ChessMove move) {
        return true;
    }

}
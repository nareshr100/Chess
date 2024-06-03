package Pieces;

import Rules.ChessMove;
import Model.Piece;

public class Rook extends Piece{

    private Rook(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.ROOK, false);
    }
    
    public static Rook create(PiecePosition pos, boolean isWhite){
        return new Rook(pos, isWhite);
    }

    @Override
    public boolean isValidMove(ChessMove move) {
        return true;
    }

}

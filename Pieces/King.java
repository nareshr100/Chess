package Pieces;

import Model.Piece;
import Rules.ChessMove;

public class King extends Piece {
    
    private King(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.KING, false);
    }
    
    public static King create(PiecePosition pos, boolean isWhite){
        return new King(pos, isWhite);
    
    }

    @Override
    public boolean isValidMove(ChessMove move) {
        return true;
    }

}

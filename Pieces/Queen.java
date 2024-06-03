package Pieces;

import Model.Move;
import Model.Piece;
import Rules.ChessMove;

public class Queen extends Piece {
    
    private Queen(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.QUEEN, false);
    }
    
    public static Queen create(PiecePosition pos, boolean isWhite){
        return new Queen(pos, isWhite);
    }

    @Override
    public boolean isValidMove(ChessMove move) {
        return true;
    }

}

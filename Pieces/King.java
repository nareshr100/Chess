package Pieces;

import Model.GameState;
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
    public boolean isValidMove(ChessMove move, GameState gameState) {
        PiecePosition startPiecePos = move.getStartPiecePosition();
        PiecePosition endPiecePos = move.getEndPiecePosition();

        int xSquares = Math.abs(endPiecePos.getCol() - startPiecePos.getCol());
        int ySquares = Math.abs(endPiecePos.getRow() - startPiecePos.getRow());

        // NEED TO IMPLEMENT CASTLING LOGIC
        return xSquares <= 1 && ySquares <= 1;
    }

}

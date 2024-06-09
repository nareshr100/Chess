package Pieces;

import Model.GameState;
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
    public boolean isValidMove(ChessMove move, GameState gameState) {
        PiecePosition startPiecePos = move.getStartPiecePosition();
        PiecePosition endPiecePos = move.getEndPiecePosition();

        int xSquares = Math.abs(endPiecePos.getCol() - startPiecePos.getCol());
        int ySquares = Math.abs(endPiecePos.getRow() - startPiecePos.getRow());

        return xSquares == ySquares || xSquares == 0 || ySquares == 0;
    }

}

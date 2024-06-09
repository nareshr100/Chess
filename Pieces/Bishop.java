package Pieces;

import Model.GameState;
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
    public boolean isValidMove(ChessMove move, GameState gameState) {

        PiecePosition startPiecePos = move.getStartPiecePosition();
        PiecePosition endPiecePos = move.getEndPiecePosition();

        int xSquares = Math.abs(endPiecePos.getCol() - startPiecePos.getCol());
        int ySquares = Math.abs(endPiecePos.getRow() - startPiecePos.getRow());

        return xSquares == ySquares;
    }

}
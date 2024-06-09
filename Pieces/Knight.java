package Pieces;

import Model.GameState;
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
    public boolean isValidMove(ChessMove move, GameState gameState) {
        PiecePosition startPiecePos = move.getStartPiecePosition();
        PiecePosition endPiecePos = move.getEndPiecePosition();

        int xSquares = Math.abs(endPiecePos.getCol() - startPiecePos.getCol());
        int ySquares = Math.abs(endPiecePos.getRow() - startPiecePos.getRow());

        return (xSquares == 1 &&  ySquares == 2) || (xSquares == 2 && ySquares == 1);
    }

}
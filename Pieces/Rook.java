package Pieces;

import Rules.ChessMove;
import Model.GameState;
import Model.Piece;

public class Rook extends Piece{

    private Rook(PiecePosition pos, boolean isWhite) {
        super(pos, isWhite, PieceType.ROOK, false);
    }
    
    public static Rook create(PiecePosition pos, boolean isWhite){
        return new Rook(pos, isWhite);
    }

    @Override
    public boolean isValidMove(ChessMove move, GameState gameState) {
        PiecePosition startPiecePos = move.getStartPiecePosition();
        PiecePosition endPiecePos = move.getEndPiecePosition();

        int xSquares = Math.abs(endPiecePos.getCol() - startPiecePos.getCol());
        int ySquares = Math.abs(endPiecePos.getRow() - startPiecePos.getRow());

        return xSquares == 0 ||  ySquares == 0;
    }

}

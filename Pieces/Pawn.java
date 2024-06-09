package Pieces;

import Model.GameState;
// import Model.Move;
import Model.Piece;
import Rules.ChessMove;

public class Pawn extends Piece {
    
    private Pawn(PiecePosition pos, boolean isWhite, boolean hasMoved) {
        super(pos, isWhite, PieceType.PAWN, hasMoved);
    }
    
    public static Pawn create(PiecePosition pos, boolean isWhite){
        return new Pawn(pos, isWhite, false);
    }

    @Override
    public boolean isValidMove(ChessMove move, GameState gameState) {

        PiecePosition startPiecePos = move.getStartPiecePosition();
        PiecePosition endPiecePos = move.getEndPiecePosition();

        int xSquares = Math.abs(endPiecePos.getCol() - startPiecePos.getCol());
        int ySquares = endPiecePos.getRow() - startPiecePos.getRow();

        Piece pieceToTake = gameState.getPieceAtPiecePosition(endPiecePos);

        boolean validMove = false;
        boolean hasMoved = this.hasMoved();
        int maxSquares = hasMoved == false ? 2 : 1;
        boolean isPlayerWhite = move.getPlayer().isWhite();  

        if (isPlayerWhite == true) {
            ySquares *= -1;
        }

        System.out.println("xSquares: " + xSquares);
        System.out.println("ySquares: " + ySquares);

        // WILL BREAK WHEN PAWN REACHES PROMOTION SQUARE
        if (ySquares > 0 && ySquares <= maxSquares && xSquares == 0) {
            return validMove = true;
        }

        // ADD TAKING DIAGONALLY LOGIC
        if (pieceToTake != null) {
            return validMove = (xSquares == 1 && ySquares == 1) ? true : false;
        }

        return validMove;

    }
}
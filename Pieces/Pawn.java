package Pieces;

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
    public boolean isValidMove(ChessMove move) {
        PiecePosition startPiecePosition = move.getStartPiecePosition();
        PiecePosition endPiecePosition = move.getEndPiecePosition();
        boolean validMove = false;
        boolean hasMoved = this.hasMoved();
        int maxSquares = 1;
        boolean isPlayerWhite = move.getPlayer().isWhite();

        if (hasMoved == false) {
            maxSquares = 2;
        }

        int squaresMoved = endPiecePosition.getRow() - startPiecePosition.getRow();
        

        if (isPlayerWhite == true) {
            squaresMoved *= -1;
        }

        // WILL BREAK WHEN PAWN REACHES PROMOTION SQUARE
        if (squaresMoved > 0 && squaresMoved <= maxSquares) {
            return validMove = true;
        }
        else {
            return validMove;
        }

    }
}
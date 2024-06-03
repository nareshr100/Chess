package Rules;

import Model.GameState;
import Model.Piece;
import Pieces.PiecePosition;

public class Rules {
    
    public static boolean isLegalMove(ChessMove move, GameState gameState){

        PiecePosition startPiecePos = move.getStartPiecePosition();
        Piece pieceToMove = gameState.getPieceAtPiecePosition(startPiecePos);
        boolean isLegalMove = pieceToMove.isValidMove(move);
        
        return isLegalMove;
    }
}

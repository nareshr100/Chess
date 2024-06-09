package Rules;

import Model.GameState;
import Model.Piece;
import Model.Player;
import Pieces.PiecePosition;

public class Rules {
    
    public static boolean isLegalMove(ChessMove move, GameState gameState){

        boolean isLegalMove = isPlayersPiece(move, gameState) && isValidMove(move, gameState) && isEndSquareAvailable(move, gameState) && isEndSquareOnBoard(move);
        
        return isLegalMove;
    }

    public static boolean isPlayersPiece(ChessMove move, GameState gameState){

        PiecePosition startPiecePos = move.getStartPiecePosition();
        Piece pieceToMove = gameState.getPieceAtPiecePosition(startPiecePos);
        boolean isPlayerssPiece = pieceToMove.isWhite() == move.getPlayer().isWhite();

        return isPlayerssPiece;

    }

    public static boolean isValidMove(ChessMove move, GameState gameState){

        PiecePosition startPiecePos = move.getStartPiecePosition();
        Piece pieceToMove = gameState.getPieceAtPiecePosition(startPiecePos);
        boolean isValidMove = pieceToMove.isValidMove(move, gameState);

        
        
        return isValidMove;
    }


    public static boolean isEndSquareAvailable(ChessMove move, GameState gameState){

        PiecePosition endPiecePos = move.getEndPiecePosition();
        Piece pieceAtFinalSquare = gameState.getPieceAtPiecePosition(endPiecePos);
        Player player = move.getPlayer();
        boolean isEndSquareAvailable = pieceAtFinalSquare == null || pieceAtFinalSquare.isWhite() != player.isWhite() ? true : false;

        System.out.println(isEndSquareAvailable);
        
        return isEndSquareAvailable;
    }

    public static boolean isEndSquareOnBoard(ChessMove move){

        PiecePosition endPiecePos = move.getEndPiecePosition();

        return endPiecePos.getCol() >= 0 && endPiecePos.getCol() <= 7 && endPiecePos.getRow() >= 0 && endPiecePos.getRow() <= 7;

    }

}

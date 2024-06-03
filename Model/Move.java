package Model;
import Pieces.PiecePosition;

public interface Move {
    PiecePosition getStartPiecePosition();
    PiecePosition getEndPiecePosition();
}

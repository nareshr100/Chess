package Model;
import java.util.List;

import Pieces.PiecePosition;

public interface IGameView {

    List<Piece> getPieces();

    void setPieces(List<Piece> pieces);

    Piece getPieceAtPiecePosition(PiecePosition piecePosition);

}
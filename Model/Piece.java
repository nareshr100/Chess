package Model;

import Pieces.PiecePosition;
import Pieces.PieceType;
import Rules.ChessMove;

public abstract class Piece {
    
    private boolean isWhite;
    private PieceType pieceType;
    private PiecePosition pos;
    private boolean hasMoved;

    public Piece(PiecePosition pos, boolean isWhite, PieceType pieceType, boolean hasMoved) {
        this.pos = pos;
        this.isWhite = isWhite;
        this.pieceType = pieceType;
        this.hasMoved = hasMoved;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public PiecePosition getPos() {
        return pos;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isValidMove(ChessMove move);

}

package Pieces;

public class Piece {
    
    private boolean isWhite;
    private PieceType pieceType;
    private PiecePosition pos;

    public Piece(PiecePosition pos, boolean isWhite, PieceType pieceType) {
        this.pos = pos;
        this.isWhite = isWhite;
        this.pieceType = pieceType;
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

}

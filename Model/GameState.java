package Model;
import java.util.ArrayList;
import java.util.List;

import Pieces.King;
import Pieces.PiecePosition;
import Pieces.Queen;
import Pieces.Rook;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Bishop;

public class GameState implements IGameView {

    private Rook bRook;
    private Knight bKnight;
    private Bishop bBishop;
    private Queen bQueen;
    private King bKing;
    private Bishop bBishop2;
    private Knight bKnight2;
    private Rook bRook2;
    private Pawn bPawn1;
    private Pawn bPawn2;
    private Pawn bPawn3;
    private Pawn bPawn4;
    private Pawn bPawn5;
    private Pawn bPawn6;
    private Pawn bPawn7;
    private Pawn bPawn8;

    private Rook wRook;
    private Knight wKnight;
    private Bishop wBishop;
    private Queen wQueen;
    private King wKing;
    private Bishop wBishop2;
    private Knight wKnight2;
    private Rook wRook2;
    private Pawn wPawn1;
    private Pawn wPawn2;
    private Pawn wPawn3;
    private Pawn wPawn4;
    private Pawn wPawn5;
    private Pawn wPawn6;
    private Pawn wPawn7;
    private Pawn wPawn8;
    private Pawn wPawn9;

    private List<Piece> pieces = new ArrayList<>();

    public GameState(){
        this.bRook = Rook.create(PiecePosition.create(0, 0), false);
        this.pieces.add(this.bRook);
        this.bKnight = Knight.create(PiecePosition.create(0, 1), false);
        this.pieces.add(this.bKnight);
        this.bBishop = Bishop.create(PiecePosition.create(0, 2), false);
        this.pieces.add(this.bBishop);
        this.bQueen = Queen.create(PiecePosition.create(0, 3), false);
        this.pieces.add(this.bQueen);
        this.bKing = King.create(PiecePosition.create(0, 4), false);
        this.pieces.add(this.bKing);
        this.bBishop2 = Bishop.create(PiecePosition.create(0, 5), false);
        this.pieces.add(this.bBishop2);
        this.bKnight2 = Knight.create(PiecePosition.create(0, 6), false);
        this.pieces.add(this.bKnight2);
        this.bRook2 = Rook.create(PiecePosition.create(0, 7), false);
        this.pieces.add(this.bRook2);
        this.bPawn1 = Pawn.create(PiecePosition.create(1, 0), false);
        this.pieces.add(this.bPawn1);
        this.bPawn2 = Pawn.create(PiecePosition.create(1, 1), false);
        this.pieces.add(this.bPawn2);
        this.bPawn3 = Pawn.create(PiecePosition.create(1, 2), false);
        this.pieces.add(this.bPawn3);
        this.bPawn4 = Pawn.create(PiecePosition.create(1, 3), false);
        this.pieces.add(this.bPawn4);
        this.bPawn5 = Pawn.create(PiecePosition.create(1, 4), false);
        this.pieces.add(this.bPawn5);
        this.bPawn6 = Pawn.create(PiecePosition.create(1, 5), false);
        this.pieces.add(this.bPawn6);
        this.bPawn7 = Pawn.create(PiecePosition.create(1, 6), false);
        this.pieces.add(this.bPawn7);
        this.bPawn8 = Pawn.create(PiecePosition.create(1, 7), false);
        this.pieces.add(this.bPawn8);

        this.wPawn1 = Pawn.create(PiecePosition.create(6, 0), true);
        this.pieces.add(this.wPawn1);
        this.wPawn2 = Pawn.create(PiecePosition.create(6, 1), true);
        this.pieces.add(this.wPawn2);
        this.wPawn3 = Pawn.create(PiecePosition.create(6, 2), true);
        this.pieces.add(this.wPawn3);
        this.wPawn4 = Pawn.create(PiecePosition.create(6, 3), true);
        this.pieces.add(this.wPawn4);
        this.wPawn5 = Pawn.create(PiecePosition.create(6, 4), true);
        this.pieces.add(this.wPawn5);
        this.wPawn6 = Pawn.create(PiecePosition.create(6, 5), true);
        this.pieces.add(this.wPawn6);
        this.wPawn7 = Pawn.create(PiecePosition.create(6, 6), true);
        this.pieces.add(this.wPawn7);
        this.wPawn8 = Pawn.create(PiecePosition.create(6, 7), true);
        this.pieces.add(this.wPawn8);
        this.wPawn9 = Pawn.create(PiecePosition.create(5, 7), true);
        this.pieces.add(this.wPawn9);

        this.wRook = Rook.create(PiecePosition.create(7, 0), true);
        this.pieces.add(this.wRook);
        this.wKnight = Knight.create(PiecePosition.create(7, 1), true);
        this.pieces.add(this.wKnight);
        this.wBishop = Bishop.create(PiecePosition.create(7, 2), true);
        this.pieces.add(this.wBishop);
        this.wQueen = Queen.create(PiecePosition.create(7, 3), true);
        this.pieces.add(this.wQueen);
        this.wKing = King.create(PiecePosition.create(7, 4), true);
        this.pieces.add(this.wKing);
        this.wBishop2 = Bishop.create(PiecePosition.create(7, 5), true);
        this.pieces.add(this.wBishop2);
        this.wKnight2 = Knight.create(PiecePosition.create(7, 6), true);
        this.pieces.add(this.wKnight2);
        this.wRook2 = Rook.create(PiecePosition.create(7, 7), true);
        this.pieces.add(this.wRook2);
    }

    @Override
    public List<Piece> getPieces(){
        return this.pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
    
    public Piece getPieceAtPiecePosition(PiecePosition piecePos) {
        for (Piece piece : pieces){
            if (piece.getPos().getRow() == piecePos.getRow() && piece.getPos().getCol() == piecePos.getCol()) {
                return piece;
            }
        }
        return null;
    }
    
}

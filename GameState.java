import java.util.ArrayList;
import java.util.List;

import Pieces.IGameView;
import Pieces.Piece;
import Pieces.PiecePosition;
import Pieces.Rook;

public class GameState implements IGameView {

    private Rook bRook;
    private List<Piece> pieces = new ArrayList<>();

    public GameState(){
        this.bRook = Rook.create(PiecePosition.create(7, 7), false);
        this.pieces.add(this.bRook);
    }

    @Override
    public List<Piece> getPieces(){
        return this.pieces;
    }
    
    
}

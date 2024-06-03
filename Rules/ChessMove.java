package Rules;
import Model.Move;
import Model.Player;
import Pieces.PiecePosition;

public class ChessMove implements Move {

    PiecePosition startPiecePosition;
    PiecePosition endPiecePosition;
    Player player;

    public ChessMove( PiecePosition startPiecePosition, PiecePosition endPiecePosition, Player player){
        this.startPiecePosition = startPiecePosition;
        this.endPiecePosition = endPiecePosition;
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public PiecePosition getStartPiecePosition() {
        return this.startPiecePosition;
    }

    @Override
    public PiecePosition getEndPiecePosition() {
        return this.endPiecePosition;
    }
    
    
}

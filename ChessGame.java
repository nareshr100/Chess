import java.io.IOException;

import Model.GameState;
import Model.IGameView;

public class ChessGame {
    
    public static void main(String[] args) throws IOException {

        IGameView gameView = new GameState();
        GameState gameState = new GameState();
        Board board = new Board(gameView, gameState);
                
    }
}
import java.io.IOException;

import Pieces.*;

public class ChessGame {
    
    public static void main(String[] args) throws IOException {

        IGameView gameView = new GameState();
        Board board = new Board(gameView);
                
    }
}
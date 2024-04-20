import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Pieces.IGameView;



public class Board {

    private static final int BOARD_LENGTH = BoardPanel.PANEL_LENGTH*BoardPanel.SQUARE_LENGTH;
    private JFrame frame = new JFrame();

    public Board(IGameView gameView) throws IOException {

        frame.setUndecorated(false);
        JPanel panel = new BoardPanel(gameView);
        frame.setBounds(10, 10, BOARD_LENGTH, BOARD_LENGTH);
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

}

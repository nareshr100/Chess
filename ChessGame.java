


import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Pieces.*;

public class ChessGame {
    
    public static void main(String[] args) throws IOException {
        
        
        
        // Piece bKnight=new Piece(1, 0, false, "knight", ps);
        // Piece bbishop=new Piece(2, 0, false, "bishop", ps);
        // Piece bqueen=new Piece(3, 0, false, "queen", ps);
        // Piece bking=new Piece(4, 0, false, "king", ps);
        // Piece bbishop2=new Piece(5, 0, false, "bishop", ps);
        // Piece bkight2=new Piece(6, 0, false, "knight", ps);
        // Piece brook2=new Piece(7, 0, false, "rook", ps);
        // Piece bpawn1=new Piece(1, 1, false, "pawn", ps);
        // Piece bpawn2=new Piece(2, 1, false, "pawn", ps);
        // Piece bpawn3=new Piece(3, 1, false, "pawn", ps);
        // Piece bpawn4=new Piece(4, 1, false, "pawn", ps);
        // Piece bpawn5=new Piece(5, 1, false, "pawn", ps);
        // Piece bpawn6=new Piece(6, 1, false, "pawn", ps);
        // Piece bpawn7=new Piece(7, 1, false, "pawn", ps);
        // Piece bpawn8=new Piece(0, 1, false, "pawn", ps);
        
        // Piece wRook = Rook.create(PiecePosition.create(0, 7), true);

        // Piece wKnight=new Piece(1, 7, true, "knight", ps);
        // Piece wbishop=new Piece(2, 7, true, "bishop", ps);
        // Piece wqueen=new Piece(3, 7, true, "queen", ps);
        // Piece wking=new Piece(4, 7, true, "king", ps);
        // Piece wbishop2=new Piece(5, 7, true, "bishop", ps);
        // Piece wkight2=new Piece(6, 7, true, "knight", ps);
        // Piece wrook2=new Piece(7, 7, true, "rook", ps);
        // Piece wpawn1=new Piece(1, 6, true, "pawn", ps);
        // Piece wpawn2=new Piece(2, 6, true, "pawn", ps);
        // Piece wpawn3=new Piece(3, 6, true, "pawn", ps);
        // Piece wpawn4=new Piece(4, 6, true, "pawn", ps);
        // Piece wpawn5=new Piece(5, 6, true, "pawn", ps);
        // Piece wpawn6=new Piece(6, 6, true, "pawn", ps);
        // Piece wpawn7=new Piece(7, 6, true, "pawn", ps);
        // Piece wpawn8=new Piece(0, 6, true, "pawn", ps);

        IGameView gameView = new GameState();
        Board board = new Board(gameView);
                
        
        
    }
}
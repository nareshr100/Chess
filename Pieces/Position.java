package Pieces;

public abstract class Position {
    private int row;
    private int col;

    protected Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

}

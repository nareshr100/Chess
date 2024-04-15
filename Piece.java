import java.util.LinkedList;

public class Piece {
    int xp;
    int yp;
    boolean isWhite;
    LinkedList<Piece> ps;
    String name;

    public Piece(int xp, int yp, boolean isWhite, String n, LinkedList<Piece> ps) {
        this.xp = xp;
        this.yp = yp;
        this.isWhite = isWhite;
        this.ps=ps;
        name = n;
        ps.add(this);
    }

    public void move(int xp, int yp){
        for(Piece p: ps){
            if(p.xp==xp && p.yp==yp){
                p.kill();
            }
        }
        this.xp=xp;
        this.yp=yp;
    }
    public void kill(){
        ps.remove(this);
    }
}

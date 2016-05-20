import java.util.List;
import java.awt.Point;
import java.util.Random;
   
public class Enemy {
    private final Random random;
    private Board board;
    Point location;
    int health;

    public Enemy(Board board, int x, int y) {
        random = new Random();
        this.board = board;
        this.location = new Point(x, y);
        health = 10;
    }

    public void move() {
        List<Point> moves = board.getConnections(location);
        location = moves.get(random.nextInt(moves.size()));
    }

    public void hit() {
        health = health - 2;
    }

    public boolean match(int x, int y) {
        if(location.x == x && location.y == y) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isSurvivor() {

        return true;

    }

    public boolean isAlive() {
        if(health > 0) {
            return true;
        }else{
            return false;
        }

    }

}

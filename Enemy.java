import java.util.List;
import java.awt.Point;
import java.util.Random;

public class Enemy {
    private final Random random;
    private Board board;
    static Point location;
    static int health;

    public Enemy(Board board, int x, int y) {
        random = new Random();
        this.board = board;
        this.location = new Point(x, y);
        health = 10;
    }

    /**
     * Method that moves the enemy to the next location. If there are multiple
     * possible locations available a random location is chosen.
     */
    public void move() {
        List<Point> moves = board.getConnections(location);
        location = moves.get(random.nextInt(moves.size()));
    }

    public static void hit() {
        health = health - 2;
    }

    public boolean match(int x, int y) {
        if(this.location.x == x && this.location.y == y) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isSurvivor() {
        for (Point endingPoint : board.getEndingPoints()) {
            if (endingPoint.equals(location)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlive() {
        if(health > 0) {
            return true;
        }else{
            return false;
        }

    }

}
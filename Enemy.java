import java.util.List;
import java.awt.Point;
import java.util.Random;


public class Enemy {
    private final Random random;
    private Board board;
    static Point location;
    static int health;

    /**
     * Constuctor for Enemy.
     * @param board the board
     * @param x Point in x-direction
     * @param y Point in y-direction
     */
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

    /**
     * The enemies takes damage.
     */
    public static void hit() {
        health = health - 2;
    }

    /**
     * A method that checks if a given location holds any towers
     * or enemies. Returns true if something is found, false otherwise.
     *
     * @param x the position in x-direction
     * @param y the position in y-direction
     * @return true if there is a match and false otherwise.
     */
    public boolean match(int x, int y) {
        if (this.location.x == x && this.location.y == y) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * A method that checks if there are any enemies at
     * an endingpoint. If so the method returns true.
     *
     * @return true if a enemy is found and false if not.
     */
    public boolean isSurvivor() {
        for (Point endingPoint : board.getEndingPoints()) {
            if (endingPoint.equals(location)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if enemy is alive
     * @return true if alive, false otherwise.
     */
    public boolean isAlive() {
        return health > 0;
    }
}

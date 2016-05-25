import java.awt.Point;

//the tower class that will be base of the tower functions.
public class Tower {
    static private Point location;
    private double range;

    /**
     * Constructor for Tower
     * @param x Point in x-direction
     * @param y Point in y-direction
     * @param range The range that the towers have for shooting enemies.
     */
    public Tower(int x, int y, double range) {
        location = new Point(x, y);
        this.range = range;
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
        return location.x == x && location.y == y;
    }

    /**
     * The towers should hit targets if they are in range. This is not
     * implemented properly
     */
    public static void hitTargets() {
        if (location.distance(location.x, location.y, Enemy.location.x, Enemy.location.y) < 2.0) {
            Enemy.hit();
        }
    }
}


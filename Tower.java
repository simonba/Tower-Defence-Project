import java.awt.Point;

//the tower class that will be base of the tower functions. Will be developed soon.....

public class Tower {
    static private Point location;
    private double range;

    public Tower(int x, int y, double range) {
        location = new Point(x, y);
        this.range = range;
    }

    public boolean match(int x, int y) {
        return location.x == x && location.y == y;
    }

    public static void hitTargets() {
        if(location.distance(location.x, location.y, Enemy.location.x, Enemy.location.y) < 2.0) {
            Enemy.hit();
        }

    }

}
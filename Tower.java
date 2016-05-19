import java.awt.Point;

//the tower class that will be base of the tower functions. Will be developed soon.....

public class Tower {
    private Point location;
    private double range;

    public Tower(int x, int y, double range) {
        location = new Point(x, y);
        this.range = range;
    }

    public boolean match(int x, int y) {
        return location.x == x && location.y == y;
    }

    public void hitTargets() {

    }

}

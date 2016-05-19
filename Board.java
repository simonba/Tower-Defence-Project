import java.util.List;
import java.awt.Point;
import java.util.ArrayList;


public class Board {

    private List<Point>[][] connections;
    private List<Point> startingPoints;
    private List<Point> endingPoints;

    public Board(int xSize, int ySize) {
        connections = new ArrayList[xSize][ySize];
        startingPoints = new ArrayList<Point>();
        endingPoints = new ArrayList<Point>();
    }

    public void addStartingPoints() {

    }

    public void addEndingPoints() {

    }

    public void isPath(int x, int y) {

    }
}

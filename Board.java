import java.util.List;
import java.awt.Point;
import java.util.ArrayList;


public class Board {

    private List<Point>[][] connections;
    private List<Point> startingPoints;
    private List<Point> endingPoints;

    /**
     * Constructor for Board.
     * @param xSize
     * @param ySize
     */
    public Board(int xSize, int ySize) {
        connections = new ArrayList[xSize][ySize];
        startingPoints = new ArrayList<Point>();
        endingPoints = new ArrayList<Point>();
    }

    /**
     * This method creates a starting point that the enemies are supposed to start on.
     *
     * @param x the position in x-direction
     * @param y the position in y-direction
     */
    public void addStartingPoint(int x, int y) {
        startingPoints.add(new Point(x,y));
    }

    /**
     * This method creates an ending point that the enemies are supposed to reach.
     *
     * @param x the position in x-direction.
     * @param y the position in y-direction.
     */
    public void addEndingPoint(int x, int y) {
        endingPoints.add(new Point(x,y));
    }

    /**
     *This method checks if there is a path between two locations.
     *
     * @param x location in x-direction.
     * @param y location in y-direction.
     * @return true if there is a path, false otherwise.
     */
    public boolean isPath(int x, int y) {
        return connections[x][y] != null;
    }

    /**
     * This method connects locations in the board.
     *
     * @param fromX connect from x-direction
     * @param fromY connect from y-direction
     * @param toX connect to x-direction
     * @param toY connect to y-direction
     */
    public void connect(int fromX, int fromY, int toX, int toY) {
        if(connections[fromX][fromY] == null) {
            connections[fromX][fromY] = new ArrayList<Point>();
        }
        if (connections[toX][toY] == null) {
            connections[toX][toY] = new ArrayList<Point>();
        }
        connections[fromX][fromY].add(new Point(toX, toY));
    }

    /**
     * This method gets what a location point on.
     *
     * @param location The location that is being investigated.
     * @return The connections as an ArrayList.
     */
    public List<Point> getConnections(Point location) {
        return connections[location.x][location.y];
    }

    /**
     *Returns the endingpoints.
     *
     * @return endingpoints.
     */
    public List<Point> getEndingPoints() {
        return endingPoints;
    }
}

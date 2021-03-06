import java.util.List;
import java.util.ArrayList;

//The Game class is the main class of the game that runs the run method and main loop.


public class Game {

    private static final int X_SIZE = 5;
    private static final int Y_SIZE = 5;
    private final Board board;
    private List<Tower> towers;
    private List<Enemy> enemies;
    Engine engine;

    /**
     * Constructor for the game. Different variables are created to be able to
     * use other classes in this class.
     */
    public Game() {
        towers = new ArrayList<Tower>();
        enemies = new ArrayList<Enemy>();
        engine = new Engine();
        board = createBoard();
        towers.add(new Tower(3, 2, 2));
        enemies.add(new Enemy(board, 0, 1));
        //enemies.add(new Enemy(board, 1, 1));
        dump(); 
    }

    /**
     * A method to run the board and then go to next step and update what gets
     * printed.
     */
    public void run() {
        while (true) {
            engine.act(enemies);
            dump();
            engine.removeSurvivors(enemies);
            Tower.hitTargets();
            if (enemies.isEmpty()) {
                dump();
                break;
            }
            if (engine.getCounter() >= 10) {
                break;
            }
        }
    }

    /**
     * Checks if there are any towers available.
     * @param x in x-direction
     * @param y in y-direction
     * @return true if a tower is found, false otherwise.
     */
    public boolean isTowerMatch(int x, int y) {
        for (Tower tower : towers) {
            if (tower.match(x, y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there are any enemies available.
     * @param x in x-direction.
     * @param y in y-direction.
     * @return true if a enemy is found, false otherwise.
     */
    public boolean isEnemyMatch(int x, int y) {
        for (Enemy enemy : enemies) {
            if (enemy.match(x, y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a Board with the specific starting and endingpoints.
     * @return the Board
     */
    private Board createBoard() {
        Board newBoard = new Board(X_SIZE, Y_SIZE);
        newBoard.addStartingPoint(0,1);
        newBoard.addEndingPoint(4,1);
        newBoard.addEndingPoint(4,3);
        newBoard.connect(0, 1, 1, 1);
        newBoard.connect(1, 1, 2, 1);
        newBoard.connect(2, 1, 3, 1);
        newBoard.connect(3, 1, 4, 1);
        newBoard.connect(2, 1, 2, 2);
        newBoard.connect(2, 2, 2, 3);
        newBoard.connect(2, 3, 3, 3);
        newBoard.connect(3, 3, 4, 3);
        return newBoard;
    }

    /**
     * Prints out the board, towers and enemies.
     */
    public void dump() {
        for (int y = 0; y < Y_SIZE; y++) {
            for (int x = 0; x < X_SIZE; x++) {
                if (isTowerMatch(x, y)) {
                    System.out.print("T");
                } else if (isEnemyMatch(x, y)) {
                    System.out.print("E");
                } else if (board.isPath(x, y)) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main (String[] args) {
        Game game = new Game();
        game.run();
    }
}

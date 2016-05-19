import java.util.List;



public class Engine {

    public Engine() {

    }

    public void act(List<Enemy> enemies) {

    }

    private void moveEnemies(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            enemy.move();
        }
    }
}

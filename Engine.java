import java.util.Iterator;
import java.util.List;
import java.util.Random;




public class Engine {

    int counter;

    public Engine() {
        counter = 0;
        Random random = new Random();
    }

    /**
     * Get how many enemies that have managed to get through the board alive.
     * @return The int number of surviving enemies.
     */
    public int getCounter() {
        return counter;
    }

    public void act(List<Enemy> enemies) {
        moveEnemies(enemies);
        //removeSurvivors(enemies);
    }

    private void moveEnemies(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            enemy.move();
        }
    }

    public void removeSurvivors(List<Enemy> enemies) {
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            if (enemy.isSurvivor()) {
                enemyIterator.remove();
                counter++;
            }
        }
    }
}

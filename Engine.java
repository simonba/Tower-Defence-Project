import java.util.Iterator;
import java.util.List;
import java.util.Random;




public class Engine {

    int counter;

    /**
     * Constructor for Engine.
     */
    public Engine() {
        counter = 0;
        Random random = new Random();
    }

    /**
     * A counter that counts all the enemies that has managed to go
     * through the board.
     * @return An int number of enemies.
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Method that Game class use to move all enemies in the board.
     * @param enemies the enemies that are being moved.
     */
    public void act(List<Enemy> enemies) {
        moveEnemies(enemies);
    }

    /**
     * Moves all enemies that exist.
     *
     * @param enemies the enemies that are being moved.
     */
    private void moveEnemies(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            enemy.move();
        }
    }

    /**
     * This method removes the surviving enemies that managed to get through
     * the board in one piece. An iterator is used to scan through the Lists and
     * will remove enemies that are at the end Points. 
     * @param enemies The List of enemies that will get iterated.
     */
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

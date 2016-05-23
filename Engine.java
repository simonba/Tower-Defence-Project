import java.util.Iterator;
import java.util.List;
import java.util.Random;




public class Engine {

    int counter;

    public Engine() {
        counter = 0;
        Random random = new Random();
    }


    public int getCounter() {
        return counter;
    }

    public void act(List<Enemy> enemies) {
        moveEnemies(enemies);
        //removeSurvivors(enemies);
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

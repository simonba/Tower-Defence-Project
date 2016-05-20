import java.util.Iterator;
import java.util.List;
import java.util.Random;




public class Engine {

    public Engine() {
        Random random = new Random();
    }

    public void act(List<Enemy> enemies) {
        moveEnemies(enemies);
        removeSurvivors(enemies);
    }

    private void moveEnemies(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            enemy.move();
        }
    }

    private void removeSurvivors(List<Enemy> enemies) {
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            if (enemy.isSurvivor() || enemy.isAlive()) {
                enemyIterator.remove();
            }
        }
    }
}

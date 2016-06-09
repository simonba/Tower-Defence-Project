import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;
import java.util.Random;

public class GameState extends BasicGameState {

    private ArrayList<Circle> towers;
    private ArrayList<Circle> enemies;
    private ArrayList<Circle> bullets;
    private Circle tower;
    private Circle enemy;
    private int time;
    private int counter = 0;
    private float x;
    private float y;
    private int a;
    private float range = 50;
    private int health = 10;
    private Random random;
    private int isInRange = 0;
    private int coins = 100;



    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        towers = new ArrayList<Circle>();
        tower = new Circle(0, 0, 20);
        enemy = new Circle(0, 0, 10);
        enemies = new ArrayList<Circle>();
        bullets = new ArrayList<Circle>();
        time = 0;

    }

    public void hitTargets() {
        health = health - 2;
    }

    public void makeBullet() {
        for (Circle tower : towers) {
            x = tower.getCenterX();
            y = tower.getCenterY();
            towers.add(new Circle(x, y, 10));
        }
    }

    public void shootEnemies() {
        for (Circle tower : towers) {
            for (Circle enemy : enemies) {
                if (tower.getCenterX() - enemy.getCenterX() <= range) {
                    hitTargets();
                } else if (tower.getCenterY() - enemy.getCenterY() <= range) {
                    hitTargets();
                }
            }
        }
    }

    public int checkHealth() {
        return health;
    }


  /*  private double distance() {
        return Math.sqrt(((tower.getCenterX() - enemy.getCenterX())*(tower.getCenterX() - enemy.getCenterX()))
        + ((tower.getCenterY() - enemy.getCenterY())*(tower.getCenterY() - enemy.getCenterY())));
    }


    public void withinRange() {
        for (Circle tower : towers) {
            for (int i = enemies.size() - 1; i >= 0; i--) {
                if (distance() < range);
                isInRange++;
            }
        }
    }
*/


    public void withinRange() {
        for (int j = towers.size() - 1; j >= 0; j--) {
            Circle torn = towers.get(j);
            for (int i = enemies.size() - 1; i >= 0; i--) {
                Circle fiende = enemies.get(i);
                if (torn.getCenterX() - fiende.getCenterX() <= range && torn.getCenterX() - fiende.getCenterX() >= -range
                        && torn.getCenterY() - fiende.getCenterY() <= range && torn.getCenterY() - fiende.getCenterY() >= -range) {
                    Random rdm = new Random();
                    int b = rdm.nextInt(1000);
                    if (b == 6) {
                        isInRange++;
                        enemies.remove(i);
                    }
                }
            }
        }
    }


    public int getCoins() {
        return coins;
    }


    public void update(GameContainer gc, StateBasedGame state, int delta) throws SlickException {


        if (counter >= 25) {
            state.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }

        if (isInRange >= 50 && counter < 25) {
            state.enterState(3, new FadeOutTransition(), new FadeInTransition());
        }

        tower.setCenterX(gc.getInput().getMouseX());
        tower.setCenterY(gc.getInput().getMouseY());

        if (gc.getInput().isKeyPressed(Input.KEY_ENTER) && getCoins() > 0) {
                x = tower.getCenterX();
                y = tower.getCenterY();
                towers.add(new Circle(x, y, 20));
                coins = coins - 10;
            }


            for (Circle tower : towers) {
                x = tower.getCenterX();
                y = tower.getCenterY();
            }
            time += delta;
            if (time > 1000) {
                time = 0;
                enemies.add(new Circle(0, 300, 13));
                bullets.add(new Circle(x, y, 5));
            }

            for (Circle enemy : enemies) {
                float center = enemy.getCenterX();
                enemy.setCenterX(center + (delta / 10f));
            }

            withinRange();

            for (Circle bullet : bullets) {
                float centerX = bullet.getCenterX();
                //float centerY = bullet.getCenterY();
                bullet.setCenterX(centerX + (delta / 5f));
                //  bullet.setCenterY(centerY+(delta/5f));
            }

            // shootEnemies();

            for (int i = enemies.size() - 1; i >= 0; i--) {
                Circle enemy = enemies.get(i);
                if (enemy.getX() > 800f) {
                    enemies.remove(i);
                    counter++;
                }
            }
        }
    



    public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {


        g.drawString("GameState, wihoo", 50, 30);
        g.drawString("Enemies killed  "+ isInRange, 50, 50);
        g.drawString("Your coins = "+ coins, 50, 70);
        g.drawString("Enemy survivors: " + counter, 50, 90);
        g.drawString("It costs 10 coins to construct a tower", 50, 110);
        g.drawString("Press Enter to construct a tower", 50, 130);
        g.drawString("Kill as many enemies as you can", 50, 150);
        g.setBackground(Color.green);

        g.setColor(Color.blue);
        g.fill(tower);

        g.setColor(Color.blue);
        for(Circle tower : towers) {
            g.fill(tower);
        }

        g.setColor(Color.black);
        for(Circle bullet : bullets) {
            g.fill(bullet);
        }

        g.setColor(Color.red);
        for(Circle enemy : enemies) {
            g.fill(enemy);
        }

    }


    public int getID() {
        return 1;
    }

}

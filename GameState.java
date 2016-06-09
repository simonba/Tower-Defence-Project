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
    private int time;
    private int counter = 0;
    private float x;
    private float y;
    private float range = Math.abs(25);
    private int health = 10;
    private Random random;



    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        towers = new ArrayList<Circle>();
        tower = new Circle(0, 0, 20);
        enemies = new ArrayList<Circle>();
        bullets = new ArrayList<Circle>();
        time = 0;

    }

    public void hitTargets() {
        health = health - 2;
    }

    public void makeBullet() {
        for(Circle tower : towers) {
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


    public void update(GameContainer gc, StateBasedGame state, int delta) throws SlickException {


        if(counter >= 25) {
            state.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }

        tower.setCenterX(gc.getInput().getMouseX());
        tower.setCenterY(gc.getInput().getMouseY());

        if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            x = tower.getCenterX();
            y = tower.getCenterY();
            towers.add(new Circle(x, y, 20));
        }

        for(Circle tower : towers) {
            x = tower.getCenterX();
            y = tower.getCenterY();
        }

        time +=delta;
        if(time>200) {
            time = 0;
            enemies.add(new Circle(0, 300, 13));
            bullets.add(new Circle(x, y, 5));
        }

        for(Circle enemy : enemies) {
            float center = enemy.getCenterX();
            enemy.setCenterX(center+(delta/5f));
            if(enemy.getCenterX() >= 800f && enemy.getCenterX() <= 800.2f) {
                counter++;
            }
        }

        for(Circle bullet : bullets) {
            float centerX = bullet.getCenterX();
            //float centerY = bullet.getCenterY();
            bullet.setCenterX(centerX+(delta/5f));
          //  bullet.setCenterY(centerY+(delta/5f));
        }
        withinRange();
    }


    public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {


        g.drawString("GameState, wihoo", 50, 50);
        g.drawString("Press Enter to construct a tower", 50, 70);
        g.drawString("Kill as many enemies as you can", 50, 90);
        g.drawString("Enemy survivors: " + counter, 50, 110);
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

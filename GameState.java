import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;

public class GameState extends BasicGameState {

    private ArrayList<Circle> towers;
    private ArrayList<Circle> enemies;
    private Circle tower;
    private int time;


    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        towers = new ArrayList<Circle>();
        tower = new Circle(0, 0, 20);
        enemies = new ArrayList<Circle>();
        time = 0;

    }



    public void update(GameContainer gc, StateBasedGame state, int delta) throws SlickException {


        if(gc.getInput().isKeyPressed(Input.KEY_2)) {
            state.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }

        tower.setCenterX(gc.getInput().getMouseX());
        tower.setCenterY(gc.getInput().getMouseY());

        time +=delta;
        if(time>200) {
            time = 0;
            enemies.add(new Circle(0, 300, 15));
        }

    }


    public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {


        g.drawString("State1", 50, 50);
        g.setBackground(Color.green);

        g.setColor(Color.blue);
        g.fill(tower);

        g.setColor(Color.red);
        for(Circle enemy : enemies) {
            g.fill(enemy);
        }

    }


    public int getID() {
        return 1;
    }

}

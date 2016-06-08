import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {


    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }



    public void update(GameContainer gc, StateBasedGame state, int delta) throws SlickException {

    }


    public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {


        g.drawString("Game Over", 300, 300);
    }


    public int getID() {
        return 1;
    }

}

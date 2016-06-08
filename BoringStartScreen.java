
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class BoringStartScreen extends BasicGameState {


    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {


        g.drawString("The most boring starting screen u have ever seen, press 1 to start the game", 50, 50);

    }

    public void update(GameContainer gc, StateBasedGame state, int delta) throws SlickException {

        if(gc.getInput().isKeyPressed(Input.KEY_1)) {
            state.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }



    }


    public int getID() {
        return 0;
    }
}

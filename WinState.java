import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class WinState extends BasicGameState {


    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }



    public void update(GameContainer gc, StateBasedGame state, int delta) throws SlickException {

        if(gc.getInput().isKeyPressed(Input.KEY_0)) {
            state.enterState(0, new FadeOutTransition(), new FadeInTransition());
        }

    }


    public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {


        g.drawString("You won! Press 0 to play again. ", 300, 300);
    }


    public int getID() {
        return 3;
    }

}

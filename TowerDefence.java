import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;


public class TowerDefence extends StateBasedGame {

    private Shape circle = null;

    public TowerDefence(String title) {
        super(title);
    }


    public void initStatesList(GameContainer gc) throws SlickException {
        circle = new Circle(5, 100, 15);

        this.addState(new BoringStartScreen());

        this.addState(new GameState());

        this.addState(new GameOverState());

        this.addState(new WinState());

    }


    public static void main (String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new TowerDefence("Tower Defence"));
        app.setDisplayMode(800, 600, false);

        app.setAlwaysRender(true);
        app.start();

    }

}

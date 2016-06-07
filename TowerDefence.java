import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;


public class TowerDefence extends BasicGame {

    private Shape circle = null;



    public TowerDefence(String title) {
        super(title);
    }

    public void init(GameContainer GC) throws SlickException {
        circle = new Circle(75, 100, 15);


    }


    public void render(GameContainer container, Graphics g) throws SlickException {
        g.draw(circle);
        g.setBackground(Color.green);


    }


    public void update(GameContainer gc, int in) throws SlickException {

    }

    public static void main (String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new TowerDefence("Tower Defence"));
        app.setDisplayMode(800, 600, false);

        app.setAlwaysRender(true);
        app.start();

    }

}

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;


public class TowerDefence extends BasicGame {

    private Shape circle = null;
//    private ArrayList<Enemy> enemies;



    public TowerDefence(String title) {
        super(title);
    }

    public void init(GameContainer GC) throws SlickException {
        circle = new Circle(5, 100, 15);


    }

//    public void enemyAnimation() {
//        Animation enemyMove = new Animation();
//       for (int i = 0; i < 50; i++) {
//        }
//    }


    public void render(GameContainer container, Graphics g) throws SlickException {
        g.draw(circle);
        g.setBackground(Color.green);


    }



    public void update(GameContainer gc, int in) throws SlickException {


        float f = circle.getX();
        f = f+0.1f;

        circle.setX(f);


    }

    public static void main (String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new TowerDefence("Tower Defence"));
        app.setDisplayMode(800, 600, false);

        app.setAlwaysRender(true);
        app.start();

    }

}

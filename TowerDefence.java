import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;


public class TowerDefence extends StateBasedGame {

    private Shape circle = null;
//    private ArrayList<Enemy> enemies;



    public TowerDefence(String title) {
        super(title);
    }

    public void initSateList(GameContainer gc) throws SlickException {
        circle = new Circle(5, 100, 15);
  

    }

//    public void enemyAnimation() {
//        Animation enemyMove = new Animation();
//       for (int i = 0; i < 50; i++) {
//        }
//    }


    public static void main (String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new TowerDefence("Tower Defence"));
        app.setDisplayMode(800, 600, false);

        app.setAlwaysRender(true);
        app.start();

    }

}

import javax.swing.JFrame;
import javax.swing.WindowConstants;

//This class just pops up a window. It was planned to be able to play the game here also....

public class Map {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Map");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

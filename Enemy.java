
public class Enemy {

    int health;

    public Enemy(Board board, int a, int b) {

        health = 10;
    }

    public void move() {

    }

    public boolean isSurvivor() {


        return true;

    }

    public boolean isAlive() {
        if(health > 0) {
            return true;
        }else{
            return false;
        }


    }


}

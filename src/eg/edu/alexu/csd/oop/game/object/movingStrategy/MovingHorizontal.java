package eg.edu.alexu.csd.oop.game.object.movingStrategy;

public class MovingHorizontal implements MovingStrategy {

    //TODO change this value
    private final int MOVE_CONST = 10;
    private int x;
    private int y;

    //initial position
    public MovingHorizontal(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
    }

    //Algorithm here
    //TODO check this code
    @Override
    public void move() {
        //x += MOVE_CONST;
    }


}

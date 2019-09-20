package eg.edu.alexu.csd.oop.game.object;

public class ClownState {
    public ClownState(int leftMaxY, int rightMaxY, int x) {
        this.leftMaxY = leftMaxY;
        this.rightMaxY = rightMaxY;
        this.x = x;
    }

    private int rightMaxY;

    public int getRightMaxY() {
        return rightMaxY;
    }

    public int getLeftMaxY() {
        return leftMaxY;
    }

    public int getX() {
        return x;
    }

    private int leftMaxY;
    private int x;
}

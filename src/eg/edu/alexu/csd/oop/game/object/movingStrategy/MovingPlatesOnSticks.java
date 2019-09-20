package eg.edu.alexu.csd.oop.game.object.movingStrategy;

import eg.edu.alexu.csd.oop.game.STATIC_VARS;
import eg.edu.alexu.csd.oop.game.object.Clown;

public class MovingPlatesOnSticks extends MovingHorizontal {

    private boolean isRight;
    private int shapeWidth;

    public MovingPlatesOnSticks(int x, int y, boolean isRight, int shapeWidth) {
        super(x, y);
        this.isRight = isRight;
        this.shapeWidth = shapeWidth;
    }

    @Override
    public void setX(int x) {
        if (isRight) {
            super.setX(Clown.getClown().getRightStickX() - shapeWidth / 2);
        }
        if (!isRight) {
            super.setX(Clown.getClown().getLeftStickX() - shapeWidth / 2);
        }

    }

}

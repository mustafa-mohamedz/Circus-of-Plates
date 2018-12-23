package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.STATIC_VARS;
import eg.edu.alexu.csd.oop.game.object.Clown;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingVertical;
import eg.edu.alexu.csd.oop.game.object.shape.Shape;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

public class FreeFall extends AbstractShapeState {

    public FreeFall() {
        super(new MovingVertical((int) (Math.random() * InitialWorld.img.getWidth()), 10));

    }

    // Algorithm
    @Override
    public ShapeState goNextState(Shape shape) {
        movingStrategy.move();
        int centerOfPlate = getX() + shape.getWidth()/2;
        int centerOfLeftStick = Clown.getClown().getLeftStickX();
        int centerOfRightStick = Clown.getClown().getRightStickX();
        if (Math.abs(centerOfPlate - centerOfLeftStick) <= STATIC_VARS.WIDTH_COLLECTION_REGION
                && Math.abs(Clown.getClown().getLeftMaxY() - (getY() + shape.getHeight()/2)) <= STATIC_VARS.HEIGHT_COLLECTION_REGION) {
            Clown.getClown().setLeftMaxY(Clown.getClown().getLeftMaxY() - shape.getHeight());
            setY(Clown.getClown().getLeftMaxY() + shape.getHeight()/4);
            setX(centerOfLeftStick - shape.getWidth()/2);
            return new OnStickState(State.ONLEFTSTICK, movingStrategy, shape.getWidth());
        } else if (Math.abs(centerOfPlate - centerOfRightStick) <= STATIC_VARS.WIDTH_COLLECTION_REGION
                && Math.abs(Clown.getClown().getRightMaxY() - (getY() + shape.getHeight()/2)) <= STATIC_VARS.HEIGHT_COLLECTION_REGION) {
            Clown.getClown().setRightMaxY(Clown.getClown().getRightMaxY() - shape.getHeight());
            setY(Clown.getClown().getRightMaxY() + shape.getHeight()/4);
            setX(centerOfRightStick - shape.getWidth()/2);
            return new OnStickState(State.ONRIGHTSTICK, movingStrategy, shape.getWidth());
        } else if (getY() > InitialWorld.img.getHeight()) {
            return new OutOfBoundries(null);
        }

        return this;
    }

    @Override
    public State getState() {
        return State.FREEFALL;
    }

}

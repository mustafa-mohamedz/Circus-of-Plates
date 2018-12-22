package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.object.Clown;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingVertical;
import eg.edu.alexu.csd.oop.game.object.shape.Shape;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

public class FreeFall implements ShapeState {

	private MovingStrategy movingStrategy;

	public FreeFall() {
		this.movingStrategy = new MovingVertical((int) (Math.random() * InitialWorld.img.getWidth()), 10);

	}

	@Override
	public int getX() {
		return movingStrategy.getX();
	}

	@Override
	public void setX(int x) {
		movingStrategy.setX(x);
	}

	@Override
	public int getY() {
		return movingStrategy.getY();
	}

	@Override
	public void setY(int y) {
		movingStrategy.setY(y);
	}

	// Algorithm
	@Override
	public ShapeState goNextState() {
		movingStrategy.move();
		int centerOfPlate = getX();
		int centerOfLeftStick = Clown.getClown().getRightStickX();
		int centerOfRightStick = Clown.getClown().getRightStickX();
		if (Math.abs(centerOfPlate - centerOfLeftStick) <= 20
				&& Math.abs(Clown.getClown().getLeftMaxY() - getY()) <= 5) {
			Clown.getClown().setLeftMaxY(Clown.getClown().getLeftMaxY() - 10);
			setX(centerOfLeftStick - 25);
			return new OnStickState(State.ONLEFTSTICK, movingStrategy);
		} else if (Math.abs(centerOfPlate - centerOfRightStick) <= 20
				&& Math.abs(Clown.getClown().getRightMaxY() - getY()) <= 5) {
			Clown.getClown().setRightMaxY(Clown.getClown().getRightMaxY() - 10);
			setX(centerOfRightStick - 25);
			return new OnStickState(State.ONRIGHTSTICK, movingStrategy);
		}else if (getY() > InitialWorld.img.getHeight()) {
			return new OutOfBoundries();
		}

		return this;
	}

}

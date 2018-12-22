package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;

public class OutOfBoundries extends AbstractShapeState {

	public OutOfBoundries(MovingStrategy movingStrategy) {
		super(movingStrategy);
	}

	@Override
	public ShapeState goNextState() {
		return this;
	}

	@Override
	public State getState() {
		return State.OUTOFBOUNDRIES;
	}

}

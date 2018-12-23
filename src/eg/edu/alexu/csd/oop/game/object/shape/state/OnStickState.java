package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingPlatesOnSticks;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.object.shape.Shape;

public class OnStickState extends AbstractShapeState {
	
	private State state;
	
	public OnStickState(State state,MovingStrategy movingStrategy, int shapeWidth) {
		super(new MovingPlatesOnSticks(movingStrategy.getX(), movingStrategy.getY(), state.equals(State.ONRIGHTSTICK), shapeWidth));
		this.state = state;
	}


	@Override
	public ShapeState goNextState(Shape shape) {
		return this;
	}

	@Override
	public State getState() {
		return this.state;
	}

}

package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingPlatesOnSticks;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;

public class OnStickState extends AbstractShapeState {
	
	private State state;
	
	public OnStickState(State state,MovingStrategy movingStrategy) {
		super(movingStrategy);
		movingStrategy = new MovingPlatesOnSticks(movingStrategy.getX(), movingStrategy.getY(), state.equals(State.ONRIGHTSTICK));
		this.state = state;
	}


	@Override
	public ShapeState goNextState() {
		return this;
	}

	@Override
	public State getState() {
		return this.state;
	}

}

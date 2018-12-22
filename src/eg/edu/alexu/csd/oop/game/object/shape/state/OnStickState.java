package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingPlatesOnSticks;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;

public class OnStickState implements ShapeState {
	private MovingStrategy movingStrategy;
	public OnStickState(State state,MovingStrategy movingStrategy) {
		movingStrategy = new MovingPlatesOnSticks(movingStrategy.getX(), movingStrategy.getY(), state.equals(State.ONRIGHTSTICK));
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShapeState goNextState() {
		// TODO Auto-generated method stub
		return null;
	}

}

package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;


public abstract class ShapeStateImp implements ShapeState {
	
	protected MovingStrategy movingStrategy;
	
	public ShapeStateImp(MovingStrategy movingStrategy) {
		this.movingStrategy = movingStrategy;
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

	@Override
	public abstract State getState();

	@Override
	public abstract ShapeState goNextState();

}

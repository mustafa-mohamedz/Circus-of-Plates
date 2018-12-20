package eg.edu.alexu.csd.oop.game.object.movingStrategy;

import eg.edu.alexu.csd.oop.game.world.InitialWorld;

public class MovingPlatesOnSticks extends MovingHorizontal {

	boolean isRight;

	public MovingPlatesOnSticks(int x, int y, boolean isRight) {
		super(x, y);
		this.isRight = isRight;
	}

	@Override
	public void setX(int x) {
		if (isRight && x >= 0) {
			super.setX(x);
		}
		if (!isRight && x <= InitialWorld.img.getWidth()) {
			super.setX(x);
		}

	}

}

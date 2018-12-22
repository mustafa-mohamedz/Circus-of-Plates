package eg.edu.alexu.csd.oop.game.object.movingStrategy;

import eg.edu.alexu.csd.oop.game.object.Clown;

public class MovingPlatesOnSticks extends MovingHorizontal {

	private boolean isRight;

	public MovingPlatesOnSticks(int x, int y, boolean isRight) {
		super(x, y);
		this.isRight = isRight;
	}

	@Override
	public void setX(int x) {
		if (isRight) {
			super.setX(Clown.getClown().getRightStickX() - 25);
		}
		if (!isRight) {
			super.setX(Clown.getClown().getLeftStickX() - 25);
		}

	}

}

package eg.edu.alexu.csd.oop.game.world.levels;

public class EasyLevel implements LevelsDifficulty {

	@Override
	public int getWroldSpeed() {
		return 60;
	}

	@Override
	public int getControlSpeed() {
		return 15;
	}

	@Override
	public int getNumOfShapesNeededToScore() {
		return 3;
	}

	@Override
	public boolean getMoreShapes() {
		return (int) (Math.random() * 5) > 3;
	}

}

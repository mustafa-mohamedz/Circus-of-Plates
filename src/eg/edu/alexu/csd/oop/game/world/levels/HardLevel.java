package eg.edu.alexu.csd.oop.game.world.levels;

public class HardLevel implements LevelsDifficulty {

	@Override
	public int getWroldSpeed() {
		return 40;
	}

	@Override
	public int getControlSpeed() {
		return 8;
	}

	@Override
	public int getNumOfShapesNeededToScore() {
		return 4;
	}

	@Override
	public boolean getMoreShapes() {
		return (int) (Math.random() * 3) > 1;
	}

}

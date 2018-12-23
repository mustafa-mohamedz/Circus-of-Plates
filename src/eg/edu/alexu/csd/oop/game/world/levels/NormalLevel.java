package eg.edu.alexu.csd.oop.game.world.levels;

public class NormalLevel implements LevelDifficulty {

	@Override
	public int getWroldSpeed() {
		return 50;
	}

	@Override
	public int getControlSpeed() {
		return 10;
	}

	@Override
	public int getNumOfShapesNeededToScore() {
		return 3;
	}

	@Override
	public boolean getMoreShapes() {
		return (int) (Math.random() * 4) > 2;
	}

}

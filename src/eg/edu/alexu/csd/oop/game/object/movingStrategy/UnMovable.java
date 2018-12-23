package eg.edu.alexu.csd.oop.game.object.movingStrategy;

public class UnMovable implements MovingStrategy {

	private int x;
	private int y;
	
	public UnMovable(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
	}

	@Override
	public void move() {

	}

}

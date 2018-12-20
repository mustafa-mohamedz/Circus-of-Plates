package eg.edu.alexu.csd.oop.game.object.plate.state;

public interface PlateState {
	
	public PlateState next();
	
	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);

	
}

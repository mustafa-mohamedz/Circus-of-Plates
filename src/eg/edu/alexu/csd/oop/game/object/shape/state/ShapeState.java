package eg.edu.alexu.csd.oop.game.object.shape.state;

public interface ShapeState {
	
	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);
	
    public ShapeState goNextState();
    
}

package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.object.shape.Shape;

public interface ShapeState {

	int getX();

	void setX(int x);

	int getY();

	void setY(int y);
	
	State getState();
	
	ShapeState goNextState(Shape shape);
    
}

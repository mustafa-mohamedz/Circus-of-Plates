package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.object.plate.state.PlateState;

public interface Shape {
	/** setter/getter for X position*/
	int getX();
	void setX(int x);
	/** setter/getter for Y position*/
	int getY();
	void setY(int y);
	/** @return object width */
	int getWidth();
	/** @return object height */
	int getHeight();
	/** @return object visible or not */
	boolean isVisible();
	/** @return object movement frames */
	java.awt.image.BufferedImage[] getSpriteImages();
			
	void goNextState();
	
}

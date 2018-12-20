package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingHorizontal;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;

public class GameObjectImp implements GameObject {

	private boolean isVisible;
	private BufferedImage[] spriteImages;
	private MovingStrategy movingStrategy;
	
	public GameObjectImp(BufferedImage[] spriteImages, MovingStrategy movingStrategy) {
		this.spriteImages = spriteImages;
		this.movingStrategy = movingStrategy;
	}
	
	@Override
	public int getX() {
		return movingStrategy.getX();
	}

	@Override
	public void setX(int x) {
		movingStrategy.setX(x);
	}

	@Override
	public int getY() {
		return movingStrategy.getY();
	}

	@Override
	public void setY(int y) {
		movingStrategy.setY(y);

	}

	@Override
	public int getWidth() {
		return spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return spriteImages[0].getHeight();
	}
	
	@Override
	public boolean isVisible() {
		return isVisible;
	}
	
	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;

	};
	
	//TODO not in interface
	public void setVisible(boolean visible) {
		isVisible = visible;
	}
	
    public void setMovingStrategy(MovingStrategy movingStrategy) {
		this.movingStrategy = movingStrategy;
    }
    
    public MovingStrategy getMovingStrategy() {
    	return this.movingStrategy;
    }

}

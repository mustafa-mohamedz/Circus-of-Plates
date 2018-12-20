package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingHorizontal;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;

public class GameObjectImp implements GameObject {

	private int width;
	private int height;
	private boolean isVisible;
	private BufferedImage[] spriteImages;
	private MovingStrategy movingStrategy;
	
	public GameObjectImp(BufferedImage[] spriteImages, MovingStrategy movingStrategy) {
		this.width = spriteImages[0].getWidth();
		this.height = spriteImages[0].getHeight();
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
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	//TODO not in interface
	public void setVisible(boolean visible) {
		isVisible = visible;
	}
	
	@Override
	public boolean isVisible() {
		return isVisible;
	}
	
	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;

	};

}

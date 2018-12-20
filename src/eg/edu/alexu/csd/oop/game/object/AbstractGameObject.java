package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class AbstractGameObject implements GameObject {

	private int x;
	private int y;
	private int width;
	private int height;
	private boolean isVisible;
	
	
	public AbstractGameObject(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
	}
	public AbstractGameObject() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;

	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	public void setVisible(boolean visible) {
		isVisible = visible;
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}
	
	@Override
	public abstract BufferedImage[] getSpriteImages();

}

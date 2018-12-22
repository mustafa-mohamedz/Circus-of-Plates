package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.object.shape.Shape;


//TODO modify methods you want to adapt
public class ShapeAdapter implements GameObject {
	
	private Shape shape;
	
	public ShapeAdapter(Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public int getX() {
		return shape.getX();
	}

	@Override
	public void setX(int x) {
		shape.setX(x);
	}

	@Override
	public int getY() {
		return shape.getY();
	}

	@Override
	public void setY(int y) {
		shape.setY(y);
	}

	@Override
	public int getWidth() {
		return shape.getWidth();
	}

	@Override
	public int getHeight() {
		return shape.getHeight();
	}

	@Override
	public boolean isVisible() {
		return shape.isVisible();
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return shape.getSpriteImages();
	}

	@Override
	public GameObject clone() {
		// TODO Auto-generated method stub
		return null;
	}



}

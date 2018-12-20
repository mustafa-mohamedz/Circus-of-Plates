package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import java.awt.image.BufferedImage;

public class Plate extends GameObjectImp {

	private String color;
	
	public String getColor() {
		return color;
	}
	
	public void SetColor(String color) {
		this.color = color;
	}
	public Plate(BufferedImage[] spriteImages, MovingStrategy movingStrategy) {
		super(spriteImages, movingStrategy);
		setVisible(true);
	}

}

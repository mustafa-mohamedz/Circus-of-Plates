package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import java.awt.image.BufferedImage;

public class Plate extends GameObjectImp {

	private static String color;
	
	public String getColor() {
		return color;
	}

	public Plate(BufferedImage[] spriteImages, MovingStrategy movingStrategy) {
		super(spriteImages, movingStrategy);
		setVisible(true);
	}

}

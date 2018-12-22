package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.UnMovable;

public class Background extends GameObjectImp {

	public Background(BufferedImage[] spriteImages) {
		super(spriteImages);
		this.movingStrategy = new UnMovable(0, 0);
	}

}

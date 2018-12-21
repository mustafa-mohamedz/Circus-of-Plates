package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingVertical;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

public class ClonablePlate extends GameObjectImp {
	private String name = "Plate";
	private String color;
	
	public String getColor() {
		return color;
	}
	
	public void SetColor(String color) {
		this.color = color;
	}
	public ClonablePlate(BufferedImage[] spriteImages, MovingStrategy movingStrategy) {
		super(spriteImages, movingStrategy);
		setVisible(true);
	}

	@Override
	public GameObjectImp clone() {
		// TODO Auto-generated method stub
		int colorId = PlateFactory.colorId;
		BufferedImage[][] plateImages = PlateFactory.plateImages;
		colorId = (int) (Math.random()*3);
		return new ClonablePlate(plateImages[colorId],new MovingVertical((int) (Math.random()*InitialWorld.img.getWidth()), 10));
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	
	

}

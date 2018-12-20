package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingVertical;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

public class PlateFactory {
	private BufferedImage [][] plateImages;
	private String [] colors;
	public PlateFactory() {
		try {
			BufferedImage red = ImageIO.read(new File("src/Images/redplate.png"));
			BufferedImage blue = ImageIO.read(new File("src/Images/blueplate.png"));
			BufferedImage green = ImageIO.read(new File("src/Images/greenplate.png"));
			plateImages = new BufferedImage[3][1];
			plateImages[0][0] = red;
			plateImages[1][0] = blue;
			plateImages[2][0] = green;
			colors = new String[]{"red","blue","green"};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Plate getRandomPlate() {
		int colorId = (int) (Math.random()*3);
		Plate RandomPlate = new Plate(plateImages[colorId],new MovingVertical((int) (Math.random()*InitialWorld.img.getWidth()), 10));
		RandomPlate.SetColor(colors[colorId]);
		return RandomPlate;
	}
	

}

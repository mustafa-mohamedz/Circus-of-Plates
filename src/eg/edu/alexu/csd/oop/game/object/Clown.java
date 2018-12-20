

package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingHorizontal;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Clown extends GameObjectImp {
	private static Clown singleClown;
	
    private Clown(BufferedImage[] clown, MovingStrategy movingStrategy) {
        super(clown, movingStrategy);
        setVisible(true);
    }

	public static Clown GetClown() {
		if (singleClown == null) {
	   		 BufferedImage[] clown = new BufferedImage[1];
		        try {
		            BufferedImage img = ImageIO.read(new File("src/Images/clown.png"));
		            clown[0] = img;
			        int x = InitialWorld.img.getWidth()/2 - img.getWidth()/2;
			        int y = InitialWorld.img.getHeight() - img.getHeight();
			        singleClown = new Clown(clown, new MovingHorizontal(x, y));
		        } catch (IOException e) {
		            throw new RuntimeException("path not found");
		        }

		}
		return singleClown;
	}
}

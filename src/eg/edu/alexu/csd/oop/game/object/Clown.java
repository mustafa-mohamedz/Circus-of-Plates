

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
	private int rightMaxY;
	public int getRightMaxY() {
		return rightMaxY;
	}

	public void setRightMaxY(int rightMaxY) {
		this.rightMaxY = rightMaxY;
	}

	public int getLeftMaxY() {
		return leftMaxY;
	}

	public void setLeftMaxY(int leftMaxY) {
		this.leftMaxY = leftMaxY;
	}

	private int leftMaxY;
	
    private Clown(BufferedImage[] clown, MovingStrategy movingStrategy) {
        super(clown);
        this.movingStrategy = movingStrategy;
        setVisible(true);
    }

	public static Clown getClown() {
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

	public int getRightStickX() {
		return singleClown.getX() + singleClown.getWidth() - 20;
	}

	public int getLeftStickX() {
		return singleClown.getX() + 20;
	}

}

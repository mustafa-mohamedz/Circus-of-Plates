

package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingHorizontal;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Clown extends GameObjectImp {
    //public static BufferedImage img;
	private static Clown singleClown;
	private MovingStrategy movingStrategy;
	
    private Clown(BufferedImage[] clown) {
        super(124, 141, clown);
        int x = InitialWorld.img.getWidth()/2 - 124/2;
        int y = InitialWorld.img.getHeight() - 141;
        movingStrategy = new MovingHorizontal(x, y);
        setVisible(true);
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
    

	public static Clown GetClown() {
		if (singleClown == null) {
	   		 BufferedImage[] clown = new BufferedImage[1];
		        try {
		            BufferedImage img = ImageIO.read(new File("src/Images/clown.png"));
		            clown[0] = img;
		        } catch (IOException e) {
		            throw new RuntimeException("path not found");
		        }
		        singleClown = new Clown(clown);
		}
		return singleClown;
	}
}

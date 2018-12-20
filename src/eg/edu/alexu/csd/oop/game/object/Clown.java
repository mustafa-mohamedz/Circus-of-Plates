

package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.world.InitialWorld;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Clown extends GameObjectImp {
    //public static BufferedImage img;

    private Clown(BufferedImage[] clown) {
        super(124, 141, clown);
        setX(InitialWorld.img.getWidth()/2 - 124/2);
        setY(InitialWorld.img.getHeight() - 141);
        setVisible(true);
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        // TODO Auto-generated method stub

        BufferedImage[] clown = new BufferedImage[1];
        try {
            img = ImageIO.read(new File("src/Images/clown.png"));
            clown[0] = img;
        } catch (IOException e) {
            throw new RuntimeException("path not found");
        }
        return clown;
    }

}

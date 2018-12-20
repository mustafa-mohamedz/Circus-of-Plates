package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.world.InitialWorld;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Clown extends AbstractGameObject {
    public static BufferedImage img;

    {
        try {
            img = ImageIO.read(new File("src/Images/clown.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Clown() {
        super(124, 141);
        setX(InitialWorld.img.getWidth()/2 - img.getWidth()/2);
        setY(InitialWorld.img.getHeight() - img.getHeight());
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

package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.world.InitialWorld;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plate extends GameObjectImp {

    private static int width = 50;
    private static int height = 10;
    private static int id = 0;
    BufferedImage img;

    public void setRight() {
        isRight = true;
    }

    public void setLeft() {
        isRight = false;
    }

    private boolean isRight;

    public boolean isRight() {
        return isRight;
    }

    @Override
    public void setX(int x) {
        if (isRight && x >= 0) {
            super.setX(x);
        }
        if (!isRight && x <= InitialWorld.img.getWidth()) {
            super.setX(x);
        }

    }

    public Plate(int x, int y) {
        super(width, height);
        setX(x);
        setY(y);
        setVisible(true);
        try {
            switch ((int) (Math.random() * 4)) {
                case 1:
                    img = ImageIO.read(new File("src/Images/redPlate.png"));
                    id = 1;
                    break;
                case 2:
                    img = ImageIO.read(new File("src/Images/bluePlate.png"));
                    id = 2;
                    break;
                case 3:
                    img = ImageIO.read(new File("src/Images/greenPlate.png"));
                    id = 3;
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException("path not found");
        }
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        // TODO Auto-generated method stub
        BufferedImage[] imgs = new BufferedImage[1];
        imgs[0] = img;
        return imgs;
    }

}

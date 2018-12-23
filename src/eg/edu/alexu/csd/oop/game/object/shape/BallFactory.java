package eg.edu.alexu.csd.oop.game.object.shape;

import eg.edu.alexu.csd.oop.game.object.GameObjectImp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BallFactory implements AbstractFactory {
    protected BufferedImage[][] ballImages;
    private String [] color;

    public BallFactory() {
        try {
            BufferedImage red = ImageIO.read(new File("src/Images/redball2.png"));
            BufferedImage blue = ImageIO.read(new File("src/Images/blueball2.png"));
            BufferedImage green = ImageIO.read(new File("src/Images/greenball2.png"));
            ballImages = new BufferedImage[3][1];
            ballImages[0][0] = red;
            ballImages[1][0] = green;
            ballImages[2][0] = blue;
            color = new String[] { "red", "blue", "green" };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameObjectImp getRandomShape() {
    	int colorId = (int) (Math.random() * 3);
        GameObjectImp RandomBall = new Ball(ballImages[colorId], color[colorId]);
        return RandomBall;
    }
}

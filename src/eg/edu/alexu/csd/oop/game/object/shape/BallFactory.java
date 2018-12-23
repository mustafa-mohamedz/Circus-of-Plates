package eg.edu.alexu.csd.oop.game.object.shape;

import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.PrototypeModule;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BallFactory implements AbstractFactory {
    protected static BufferedImage[][] ballImages;
    private static int colorId;

    public BallFactory() {
        try {
            BufferedImage red = ImageIO.read(new File("src/Images/redball2.png"));
            BufferedImage blue = ImageIO.read(new File("src/Images/blueball2.png"));
            BufferedImage green = ImageIO.read(new File("src/Images/greenball2.png"));
            ballImages = new BufferedImage[3][1];
            ballImages[0][0] = red;
            ballImages[1][0] = green;
            ballImages[2][0] = blue;
            colorId = (int) (Math.random() * 3);
            initializeProtoTypes(colorId);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void initializeProtoTypes(int colorId) {
        PrototypeModule.addPrototype(new Ball(ballImages[colorId], colorId));
    }

    @Override
    public GameObjectImp getRandomShape() {
        GameObjectImp RandomBall = PrototypeModule.clonePrototype("Ball");
        return RandomBall;
    }
}

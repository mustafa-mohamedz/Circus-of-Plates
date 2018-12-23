package eg.edu.alexu.csd.oop.game.object.shape;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.PrototypeModule;

public class PlateFactory implements AbstractFactory {
    protected static BufferedImage[][] plateImages;
    private static int colorId;

    public PlateFactory() {
        try {
            BufferedImage red = ImageIO.read(new File("src/Images/redplate.png"));
            BufferedImage blue = ImageIO.read(new File("src/Images/blueplate.png"));
            BufferedImage green = ImageIO.read(new File("src/Images/greenplate.png"));
            plateImages = new BufferedImage[3][1];
            plateImages[0][0] = red;
            plateImages[1][0] = green;
            plateImages[2][0] = blue;
            colorId = (int) (Math.random() * 3);
            initializeProtoTypes(colorId);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public GameObjectImp getRandomShape() {
        GameObjectImp RandomPlate = PrototypeModule.clonePrototype("Plate");
        return RandomPlate;
    }

    @Override
    public void initializeProtoTypes(int colorId) {
        PrototypeModule.addPrototype(new Plate(plateImages[colorId], colorId));

    }


}

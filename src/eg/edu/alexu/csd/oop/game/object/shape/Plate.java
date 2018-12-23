package eg.edu.alexu.csd.oop.game.object.shape;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.STATIC_VARS;
import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.shape.state.FreeFall;
import eg.edu.alexu.csd.oop.game.object.shape.state.ShapeState;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;


public class Plate extends Shape {

    public Plate(BufferedImage[] spriteImages, int colorId) {
        super(spriteImages, colorId);
    }

    @Override
    public GameObjectImp clone() {
        BufferedImage[][] plateImages = PlateFactory.plateImages;
        int colorId = (int) (Math.random() * 3);
        return new Plate(plateImages[colorId], colorId);
    }

    @Override
    public int getWidth() {
        return STATIC_VARS.PLATE_WIDTH;
    }

    @Override
    public int getHeight() {
        return STATIC_VARS.PLATE_HEIGHT;
    }

    @Override
    public Object getName() {
        return "Plate";
    }
}

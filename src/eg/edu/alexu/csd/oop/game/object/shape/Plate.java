package eg.edu.alexu.csd.oop.game.object.shape;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.STATIC_VARS;
import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.shape.state.FreeFall;
import eg.edu.alexu.csd.oop.game.object.shape.state.ShapeState;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;


public class Plate extends Shape {

    public Plate(BufferedImage[] spriteImages, String color) {
        super(spriteImages, color);
    }

    @Override
    public GameObjectImp clone() {
        return new Plate(getSpriteImages(), getColor());
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
        return color + "Plate";
    }
}

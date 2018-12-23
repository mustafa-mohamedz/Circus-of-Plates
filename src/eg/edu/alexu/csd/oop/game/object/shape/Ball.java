package eg.edu.alexu.csd.oop.game.object.shape;

import eg.edu.alexu.csd.oop.game.STATIC_VARS;
import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.shape.state.FreeFall;
import eg.edu.alexu.csd.oop.game.object.shape.state.ShapeState;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;

import java.awt.image.BufferedImage;

public class Ball extends Shape {

    public Ball(BufferedImage[] spriteImages, String color) {
        super(spriteImages, color);
    }
    @Override
    public int getWidth() {
        return STATIC_VARS.BALL_WIDTH;
    }

    @Override
    public int getHeight() {
        return STATIC_VARS.BALL_HEIGHT;
    }

    @Override
    public Object getName() {
        return color + "Ball";
    }
	

}

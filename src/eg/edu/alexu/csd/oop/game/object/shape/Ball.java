package eg.edu.alexu.csd.oop.game.object.shape;

import eg.edu.alexu.csd.oop.game.STATIC_VARS;
import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.shape.state.FreeFall;
import eg.edu.alexu.csd.oop.game.object.shape.state.ShapeState;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;

import java.awt.image.BufferedImage;

public class Ball extends Shape {

    public Ball(BufferedImage[] spriteImages, int colorId) {
        super(spriteImages, colorId);
    }

    @Override
    public GameObjectImp clone() {
        BufferedImage[][] ballImages = BallFactory.ballImages;
        int colorId = (int) (Math.random() * 3);
        return new Ball(ballImages[colorId], colorId);
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
        return "Ball";
    }

}

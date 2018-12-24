package eg.edu.alexu.csd.oop.game.object.shape;

import eg.edu.alexu.csd.oop.game.STATIC_VARS;
import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.shape.state.FreeFall;
import eg.edu.alexu.csd.oop.game.object.shape.state.OnStickState;
import eg.edu.alexu.csd.oop.game.object.shape.state.OutOfBoundries;
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
    @Override
	public Shape clone() {
		Ball x = new Ball(getSpriteImages(), getColor());
		if (currentState.getState().equals(State.FREEFALL)) {
			x.currentState = new FreeFall(getX(), getY());
		}else if (currentState.getState().equals(State.ONLEFTSTICK)||currentState.getState().equals(State.ONRIGHTSTICK)) {
			x.currentState = new OnStickState(currentState.getState(), movingStrategy, getWidth());
		}else {
			x.currentState = new OutOfBoundries(movingStrategy);
		}
		return x;
	}


}

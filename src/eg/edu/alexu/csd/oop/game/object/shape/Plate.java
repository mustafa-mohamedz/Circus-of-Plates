package eg.edu.alexu.csd.oop.game.object.shape;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.STATIC_VARS;
import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.shape.state.FreeFall;
import eg.edu.alexu.csd.oop.game.object.shape.state.OnStickState;
import eg.edu.alexu.csd.oop.game.object.shape.state.OutOfBoundries;
import eg.edu.alexu.csd.oop.game.object.shape.state.ShapeState;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;


public class Plate extends Shape {

    public Plate(BufferedImage[] spriteImages, String color) {
        super(spriteImages, color);
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

	@Override
	public Shape clone() {
		Plate x = new Plate(getSpriteImages(), getColor());
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

package eg.edu.alexu.csd.oop.game.object.shape;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;

public interface Shape extends GameObject {
	
	
	State goNextState();
	
    String getName();
    String getColor();
}


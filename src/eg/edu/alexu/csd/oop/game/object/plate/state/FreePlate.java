package eg.edu.alexu.csd.oop.game.object.plate.state;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingVertical;

//(Movable plate)
public class FreePlate implements PlateState {
		
	
	private MovingStrategy movingStrategy;

	public FreePlate() {
		this.movingStrategy = new MovingVertical();
	}

	@Override
	public int getX() {
		return movingStrategy.getX();
	}


	@Override
	public void setX(int x) {
		movingStrategy.setX(x);
	}


	@Override
	public int getY() {
		return movingStrategy.getY();
	}


	@Override
	public void setY(int y) {
		movingStrategy.setY(y);	
	}


	//Algorithm
	//TODO check this code
	@Override
	public PlateState next() {
		movingStrategy.move();
		/*
		if(// fall on left stack) {
			
			
		}else if (//fall on right stack) {
			
			
		}
		//still free
		else {
			return this; 
		}
		*/
		return null;
	}

}

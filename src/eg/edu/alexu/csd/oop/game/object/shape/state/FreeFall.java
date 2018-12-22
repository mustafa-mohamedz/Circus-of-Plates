package eg.edu.alexu.csd.oop.game.object.shape.state;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingVertical;
import eg.edu.alexu.csd.oop.game.object.shape.Shape;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

public class FreeFall implements ShapeState {

	private MovingStrategy movingStrategy;
	private Shape shape;

	public FreeFall(Shape shape) {
		this.shape = shape;
		this.movingStrategy = new MovingVertical((int) (Math.random()*InitialWorld.img.getWidth()), 10);

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

	// Algorithm
	@Override
	public int goNextState() {
		movingStrategy.move();
		return 0;
		
//		if(//fall on left stack) {
//		  
//		  
//		}else if(fall on right stack) {
//
//			 //still free 
//			 
//		}else {
//		}
	}
		 
}

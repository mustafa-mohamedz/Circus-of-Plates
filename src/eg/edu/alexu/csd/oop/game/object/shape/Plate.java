package eg.edu.alexu.csd.oop.game.object.shape;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.shape.state.FreeFall;
import eg.edu.alexu.csd.oop.game.object.shape.state.ShapeState;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;


public class Plate extends GameObjectImp implements Shape {
	
    private final String name = "Plate";
    private String color;
    private ShapeState currentState;

    

    public String getColor() {
        return color;
    }

    public void SetColor(String color) {
        this.color = color;
    }

    @Override
    public int getX() {
        return currentState.getX();
    }

    @Override
    public void setX(int x) {
    	currentState.setX(x);
    }

    @Override
    public int getY() {
        return currentState.getY();
    }

    @Override
    public void setY(int y) {
    	currentState.setY(y);
    }
    
    
    public Plate(BufferedImage[] spriteImages, int colorId) {
        super(spriteImages);
        this.currentState = new FreeFall((Shape)this);
        switch (colorId) {
            case 0:
                color = "red";
                break;
            case 1:
                color = "green";
                break;
            case 2:
                color = "blue";
                break;
            default:
                break;
        }
        setVisible(true);
    }

    @Override
    public GameObjectImp clone() {
        int colorId = PlateFactory.colorId;
        BufferedImage[][] plateImages = PlateFactory.plateImages;
        colorId = (int) (Math.random() * 3);
        return new Plate(plateImages[colorId], colorId);
    }

    @Override
    public String getName() {
        return name;
    }

	@Override
	public State goNextState() {
		this.currentState = currentState.goNextState();
		return currentState.getState();
	}

}

package eg.edu.alexu.csd.oop.game.object.shape;

import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.shape.state.FreeFall;
import eg.edu.alexu.csd.oop.game.object.shape.state.ShapeState;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;

import java.awt.image.BufferedImage;

public abstract class Shape extends GameObjectImp {

    protected String color;
    protected ShapeState currentState;


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

    public Shape(BufferedImage[] spriteImages, String color) {
        super(spriteImages);
        this.currentState = new FreeFall();
        this.color = color;
        setVisible(true);
    }

    public State goNextState() {
        this.currentState = currentState.goNextState(this);
        return currentState.getState();
    }

    public abstract Object getName();
}


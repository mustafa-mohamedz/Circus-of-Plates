package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingStrategy;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingVertical;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

public class Plate extends GameObjectImp implements MovableObject {
    private final String name = "Plate";
    private String color;

    @Override
    public boolean isPositionRight() {
        return positionRight;
    }

    @Override
    public void setPositionRight(boolean positionRight) {
        this.positionRight = positionRight;
    }

    private boolean positionRight;

    public String getColor() {
        return color;
    }

    public void SetColor(String color) {
        this.color = color;
    }

    public Plate(BufferedImage[] spriteImages, int colorId, MovingStrategy movingStrategy) {
        super(spriteImages, movingStrategy);
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
        // TODO Auto-generated method stub
        int colorId = PlateFactory.colorId;
        BufferedImage[][] plateImages = PlateFactory.plateImages;
        colorId = (int) (Math.random() * 3);
        return new Plate(plateImages[colorId], colorId, new MovingVertical((int) (Math.random() * InitialWorld.img.getWidth()), 10));
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }
}

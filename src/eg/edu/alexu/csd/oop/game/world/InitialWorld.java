package eg.edu.alexu.csd.oop.game.world;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.object.GameObjectImp;
import eg.edu.alexu.csd.oop.game.object.Clown;
import eg.edu.alexu.csd.oop.game.object.Plate;
import eg.edu.alexu.csd.oop.game.object.PlateFactory;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingPlatesOnSticks;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.UnMovable;

public class InitialWorld implements World {
    private List<GameObject> constantObjects;
    private List<GameObject> movableObjects;
    private List<GameObject> controlableObjects;
    private int width;
    private int height;
    private int speed;
    private int rightMaxY;
    private int leftMaxY;
    public static BufferedImage img;
    private PlateFactory plateFactory;

    static {
        try {
            img = ImageIO.read(new File("src/Images/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InitialWorld(int width, int height, int speed) {
        this.width = width;
        this.height = height;
        this.speed = speed;
        constantObjects = new ArrayList<>();
        BufferedImage[] backGround = new BufferedImage[1];
        backGround[0] = img;
        constantObjects.add(new GameObjectImp(backGround,new UnMovable(0,0)));
        ((GameObjectImp)constantObjects.get(0)).setVisible(true);
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        controlableObjects.add(Clown.GetClown());
        leftMaxY = rightMaxY = img.getHeight() - Clown.GetClown().getHeight();
        plateFactory = new PlateFactory();
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constantObjects;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        // TODO Auto-generated method stub
        return movableObjects;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        // TODO Auto-generated method stub
        return controlableObjects;
    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return width;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return height;
    }

    @Override
    public boolean refresh() {
    	if ((int)(Math.random()*2)>0) {
    		movableObjects.add(plateFactory.getRandomPlate());
		}
        
        int centerOfPlate;
        int centerOfLeftStick = controlableObjects.get(0).getX() + 20;
        int centerOfRightStick = controlableObjects.get(0).getX() + controlableObjects.get(0).getWidth() - 20;

        for (int i = 0; i < movableObjects.size(); i++) {
            GameObject temp = movableObjects.get(i);
            temp.setY(temp.getY() + 10);
            centerOfPlate = temp.getX() + temp.getWidth() / 2;
            if (temp.getY() >= img.getHeight()) {
                movableObjects.remove(i);
                continue;
            }
            if (Math.abs(centerOfPlate - centerOfLeftStick) <= 20 && Math.abs(leftMaxY - temp.getY()) <= 5) {
                leftMaxY -= 10;
                movableObjects.remove(i);
                ((GameObjectImp) temp).setMovingStrategy(new MovingPlatesOnSticks(temp.getX(), temp.getY(), false));
                temp.setX(centerOfLeftStick - 25);
                controlableObjects.add(temp);
                continue;
            }
            if (Math.abs(centerOfPlate - centerOfRightStick) <= 20
                    && Math.abs(rightMaxY - temp.getY()) <= 5) {
                rightMaxY -= 10;
                movableObjects.remove(i);
                ((GameObjectImp) temp).setMovingStrategy(new MovingPlatesOnSticks(temp.getX(), temp.getY(), true));
                temp.setX(centerOfRightStick - 25);
                controlableObjects.add(temp);
                continue;
            }
        }
        return true;
    }

    @Override
    public String getStatus() {
        // TODO Auto-generated method stub
        return "Score = " + 0 + "   |   Time = 0";
    }

    @Override
    public int getSpeed() {
        // TODO Auto-generated method stub
        return 30;
    }

    @Override
    public int getControlSpeed() {
        // TODO Auto-generated method stub
        return 10;
    }

}

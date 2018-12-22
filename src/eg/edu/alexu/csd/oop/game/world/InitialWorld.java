package eg.edu.alexu.csd.oop.game.world;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.sun.webkit.Timer;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.object.*;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.MovingPlatesOnSticks;
import eg.edu.alexu.csd.oop.game.object.movingStrategy.UnMovable;
import eg.edu.alexu.csd.oop.game.object.shape.PlateFactory;
import eg.edu.alexu.csd.oop.game.object.shape.Shape;
import eg.edu.alexu.csd.oop.game.object.shape.state.State;

public class InitialWorld implements World {
    private List<GameObject> constantObjects;
    private List<GameObject> movableObjects;
    private List<GameObject> controlableObjects;
    private List<GameObject> onRightStick;
    private List<GameObject> onLeftStick;

    private Observable observable;
    private int width;
    private int height;
    private int speed;
    private int score;
    private long time;

    public static BufferedImage img;
    private PlateFactory plateFactory;

    static {
        try {
            img = ImageIO.read(new File("src/Images/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InitialWorld(int width, int height, int speed, Observable observable) {
        time = System.currentTimeMillis();
        this.observable = observable;
        this.observable.add(this);
        this.width = width;
        this.height = height;
        this.speed = speed;
        constantObjects = new ArrayList<>();
        BufferedImage[] backGround = new BufferedImage[1];
        backGround[0] = img;
        constantObjects.add(new Background(backGround));
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        onLeftStick = new ArrayList<>();
        onRightStick = new ArrayList<>();
        controlableObjects.add(Clown.getClown());
        Clown.getClown().setLeftMaxY(img.getHeight() - Clown.getClown().getHeight());
        Clown.getClown().setRightMaxY(img.getHeight() - Clown.getClown().getHeight());
        plateFactory = new PlateFactory();
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constantObjects;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return movableObjects;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return controlableObjects;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean refresh() {
        if ((int) (Math.random() * 4) > 2) {
            movableObjects.add(plateFactory.getRandomPlate());
        }
        for (int i = 0; i < movableObjects.size(); i++) {
            Shape tmp = (Shape) movableObjects.get(i);
            State state = tmp.goNextState();
            if (state.equals(State.OUTOFBOUNDRIES)) {
                movableObjects.remove(i);
                continue;
            }else if (state.equals(State.ONLEFTSTICK)) {
            	controlableObjects.add(movableObjects.remove(i));
            	onLeftStick.add(tmp);
                if (observable.setScore(onLeftStick)) {
                    for (int j = 0; j < 3; j++) {
                        controlableObjects.remove(onLeftStick.remove(onLeftStick.size() - 1));
                        Clown.getClown().setLeftMaxY(Clown.getClown().getLeftMaxY() + 10);
                    }
                }
			}
            else if (state.equals(State.ONRIGHTSTICK)) {
                controlableObjects.add(movableObjects.remove(i));
                onRightStick.add(tmp);
                if (observable.setScore(onRightStick)) {
                    for (int j = 0; j < 3; j++) {
                        controlableObjects.remove(onRightStick.remove(onRightStick.size() - 1));
                        Clown.getClown().setRightMaxY(Clown.getClown().getRightMaxY() + 10);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String getStatus() {
        return "Score = " + score + "   |   Time = " + (60 - (System.currentTimeMillis() - time) / 1000);
    }

    @Override
    public int getSpeed() {
        return 50;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

    @Override
    public void update(int score) {
        this.score = score;
    }


}

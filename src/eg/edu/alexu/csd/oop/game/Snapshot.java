package eg.edu.alexu.csd.oop.game;

import eg.edu.alexu.csd.oop.game.object.Clown;
import eg.edu.alexu.csd.oop.game.object.ClownState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Snapshot {
    private ClownState clownState;

    public List<GameObject> getConstantObjects() {
        return constantObjects;
    }

    public void setConstantObjects(List<GameObject> constantObjects) {
        this.constantObjects = constantObjects.stream().map(GameObject::clone).collect(Collectors.toList());
    }

    public List<GameObject> getMovableObjects() {
        return movableObjects;
    }

    public void setMovableObjects(List<GameObject> movableObjects) {
        this.movableObjects = movableObjects.stream().map(GameObject::clone).collect(Collectors.toList());
    }

    public List<GameObject> getControlableObjects() {
        Clown.getClown().setRightMaxY(clownState.getRightMaxY());
        Clown.getClown().setLeftMaxY(clownState.getLeftMaxY());
        Clown.getClown().setX(clownState.getX());
        return controlableObjects;
    }

    public void setControlableObjects(List<GameObject> controlableObjects) {
        clownState = new ClownState(Clown.getClown().getLeftMaxY(), Clown.getClown().getRightMaxY(), Clown.getClown().getX());
        this.controlableObjects = new ArrayList<>();
        this.controlableObjects.add(controlableObjects.get(0));
        for (GameObject go1 : onRightStick) this.controlableObjects.add(go1);
        for (GameObject go2 : onLeftStick) this.controlableObjects.add(go2);
    }

    public List<GameObject> getOnRightStick() {
        return onRightStick;
    }

    public void setOnRightStick(List<GameObject> onRightStick) {
        this.onRightStick = onRightStick.stream().map(GameObject::clone).collect(Collectors.toList());
    }

    public List<GameObject> getOnLeftStick() {
        return onLeftStick;
    }

    public void setOnLeftStick(List<GameObject> onLeftStick) {
        this.onLeftStick = onLeftStick.stream().map(GameObject::clone).collect(Collectors.toList());
    }

    private List<GameObject> constantObjects;
    private List<GameObject> movableObjects;
    private List<GameObject> controlableObjects;
    private List<GameObject> onRightStick;
    private List<GameObject> onLeftStick;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private long time;
}

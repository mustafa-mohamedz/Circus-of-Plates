package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.object.Iterator;

import java.util.List;

public class ObjectIterator implements Iterator {
    private List<GameObject> controlableObjects;
    private int position;

    // for the sake of simplicity in our Implementation, we need to Iterate backwards & skipped element # 0 because it's the clown.
    public ObjectIterator(List<GameObject> controlableObjects) {
        this.controlableObjects = controlableObjects;
        position = controlableObjects.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public GameObject next() {
        if(position < 0) throw new IndexOutOfBoundsException("There're No More Elements in the Collection to Iterate through");
        return controlableObjects.get(position--);
    }
}

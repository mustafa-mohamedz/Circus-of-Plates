package eg.edu.alexu.csd.oop.game.object.shape;

import eg.edu.alexu.csd.oop.game.object.GameObjectImp;

public interface AbstractFactory {
    void initializeProtoTypes(int colorId);
    GameObjectImp getRandomShape();
}

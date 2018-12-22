package eg.edu.alexu.csd.oop.game.object;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.object.shape.Shape;


public class PrototypeModule {
	private static List<GameObjectImp> prototypes = new ArrayList<>();

	public static void addPrototype(GameObjectImp p) {
		prototypes.add(p);
	}

	public static GameObjectImp clonePrototype(String name) {
		for (GameObjectImp p : prototypes) {
			if (((Shape)p).getName().equals(name)) {
				return (GameObjectImp) p.clone();
			}
		}
		return null;
	}
}

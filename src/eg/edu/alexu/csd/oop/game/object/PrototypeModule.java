package eg.edu.alexu.csd.oop.game.object;

import java.util.ArrayList;
import java.util.List;


public class PrototypeModule {
	private static List<GameObjectImp> prototypes = new ArrayList<>();

	public static void addPrototype(GameObjectImp p) {
		prototypes.add(p);
	}

	public static GameObjectImp clonePrototype(String name) {
		for (GameObjectImp p : prototypes) {
			if (((MovableObject)p).getName().equals(name)) {
				return (GameObjectImp) p.clone();
			}
		}
		return null;
	}
}

package eg.edu.alexu.csd.oop.game.object;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

public class Observable {
	private List<World> observers = new ArrayList<>(); 
	private int score;
	
	
	public void add(World w) {
		observers.add(w);
	}
	public void remove(World w) {
		observers.remove(w);
	}
	public int getScore() {
		return this.score;
	}
	public boolean setScore(List<GameObject> list) {
		boolean isChanged  = execute(list);
		notifyObservers();
		return isChanged;
	}
	public boolean execute(List<GameObject> list){
		// Iterator Pattern
		Iterator objectIterator = new ObjectIterator(list);
		if(list.size() == 0) return false;
		int counter = 1;
		MovableObject firstElement = (MovableObject) objectIterator.next();
		String currentColor = firstElement.getColor();

		while (objectIterator.hasNext()) {
			MovableObject object = (MovableObject) objectIterator.next();
			if (object.getColor().equals(currentColor)) counter++;
			else break;
		}
		if(counter == 3) {
			score++;
			return true;
		}
		return false;
	}
	public void notifyObservers(){
		for(World w : observers) {
			w.update(this.score);
		}
	}
	
	
	
	

}

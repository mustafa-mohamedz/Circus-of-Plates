package eg.edu.alexu.csd.oop.game.object;

import java.util.ArrayList;
import java.util.List;

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
	public void setScore() {
		execute();
		notifyObservers();
	}
	public void execute(){
		// Iterator Pattern
		
		
	}
	public void notifyObservers(){
		for(World w : observers) {
			w.update(this.score);
		}
	}
	
	
	
	

}

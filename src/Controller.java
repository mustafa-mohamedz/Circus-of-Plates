import java.awt.Button;

public class Controller {
	private Button newGame = new Button();
	private Button loadGame = new Button();
	private Button exit = new Button();
	
	public void exit() {
		System.exit(0);
	}
	public void newGame() {
		FirstMain.end();
		Main.main(null);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

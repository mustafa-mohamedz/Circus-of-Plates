
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
	@FXML
	private Button newGame = new Button();
	private Button loadGame = new Button();
	private Button exit = new Button();
	
	public void exit() {
		System.exit(0);
		FirstMain.end();
		Main.main(null);
		
	}
	public void newGame() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondMainDesign.fxml"));
        Parent root = loader.load();
        Stage primaryStage = (Stage) newGame.getScene().getWindow();
        primaryStage.setScene(new Scene(root, 900, 500));
	}
	public void easy() {
		FirstMain.end();
		String[] arg = {"easy"};
		Main.main(arg);
		
	}
	public void normal() {
		FirstMain.end();
		String[] arg = {"normal"};
		Main.main(arg);
		
	}
	public void hard() {
		FirstMain.end();
		String[] arg = {"hard"};
		Main.main(arg);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

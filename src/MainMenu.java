import eg.edu.alexu.csd.oop.game.SoundPlayer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application {
    private static Helper instance;

    public static Helper getInstance() {
        if (instance == null) {
            instance = new Helper();
        }
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        getInstance().openWindow("Main.fxml", primaryStage);
        SoundPlayer.play("src/Images/sound.wav");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Helper{
    public static Stage primaryStage;

    public void end() {
        primaryStage.close();
    }

    public void levelChoose() throws IOException {
        end();
        openWindow("LevelChooser.fxml", primaryStage);
    }

    void openWindow(String fxFileName, Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxFileName));
        primaryStage.setTitle("Circus Of Plates");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        this.primaryStage = primaryStage;
    }
}
	



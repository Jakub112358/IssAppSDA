package iss;

import iss.view.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager sceneManager = new SceneManager();
        stage.setTitle("WELCOME TO SPACE");
        stage.setScene(sceneManager.getHelloScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
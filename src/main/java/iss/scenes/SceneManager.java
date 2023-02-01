package iss.scenes;

import iss.Launcher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneManager {
    public Scene getHelloScene () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("first-view.fxml"));
        return new Scene(fxmlLoader.load(), 600, 400);
    }

}

package iss.scenes;

import iss.Launcher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneManager {
    public Scene getHelloScene () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("hello-view.fxml"));
        return new Scene(fxmlLoader.load(), 320, 240);
    }

}

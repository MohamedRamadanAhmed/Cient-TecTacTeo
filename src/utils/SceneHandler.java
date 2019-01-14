package utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneHandler {

    private static SceneHandler instance;
    private Stage stage;
    private Scene scene;

    private SceneHandler() {
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(String FXMLFileName, String scenceTitle, int xDimentions, int yDimintions, boolean isResizable) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(FXMLFileName));
        Scene scene = new Scene(root);
        stage.setTitle(scenceTitle);
        stage.setResizable(isResizable);
        stage.setScene(scene);
    }

    public void setScene(Parent parent) throws IOException {
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }

    public static SceneHandler getInstance() {
        if (instance == null) {
            synchronized (SceneHandler.class) {
                if (instance == null) {
                    instance = new SceneHandler();
                }
            }
        }
        return instance;
    }
}

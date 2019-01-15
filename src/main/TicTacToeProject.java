package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.SceneHandler;

public class TicTacToeProject extends Application {

    private SceneHandler handler = SceneHandler.getInstance();

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Parent root = null;
//        root = FXMLLoader.load(getClass().getResource("/choosemode/SelectMode.fxml"));
//        Utils.switchWindow(root);
        handler.setScene("/choosemode/SelectMode.fxml", " Select Mode", 800, 800, true);
    }
}

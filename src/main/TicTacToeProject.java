package main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import utils.Utils;

public class TicTacToeProject extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = null;

        root = FXMLLoader.load(getClass().getResource("/choosemode/SelectMode.fxml"));
        Utils.switchWindow(root);

    }
}

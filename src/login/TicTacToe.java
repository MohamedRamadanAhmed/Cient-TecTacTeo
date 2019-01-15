package login;

import javafx.application.Application;
import javafx.stage.Stage;
import utils.SceneHandler;

/**
 *
 * @author Amer Shaker
 */
public class TicTacToe extends Application {

    private SceneHandler handler;

    public TicTacToe() {
        handler = SceneHandler.getInstance();
    }

    @Override
    public void start(Stage stage) throws Exception {
        handler.setStage(stage);
        handler.setScene("/sinup/signup.fxml", "Sign up", 800, 800, true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

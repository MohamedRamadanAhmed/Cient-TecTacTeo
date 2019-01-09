package view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    
        
        NewModeBase root = new NewModeBase(primaryStage);
        
        
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    
}

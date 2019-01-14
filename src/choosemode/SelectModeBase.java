package choosemode;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.SceneHandler;

public class SelectModeBase extends Application {

    protected AnchorPane anchorPane;
    protected AnchorPane anchorPane0;
    protected Button singleMode;
    protected Button multiMode;
    protected Label label;
    Stage primStage;
    SceneHandler handler;

    public SelectModeBase() {

    }

    public static void main(String[] args) {
        //System.out.println("abdo awd multiModeAction");
        SelectModeBase base = new SelectModeBase();
        base.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        handler = SceneHandler.getInstance();
        handler.setStage(primaryStage);

        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        singleMode = new Button("single");
        multiMode = new Button("multi");
        label = new Label();

        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(600.0);
        anchorPane.setStyle("-fx-background-color: #010226;");

        anchorPane0.setLayoutX(44.0);
        anchorPane0.setLayoutY(100.0);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(523.0);
        anchorPane0.setStyle("-fx-background-color: #a90226;");

        singleMode.setLayoutX(84.0);
        singleMode.setLayoutY(123.0);
        singleMode.setMnemonicParsing(false);
        singleMode.setPrefHeight(25.0);
        singleMode.setPrefWidth(158.0);
        singleMode.setStyle("-fx-background-color: #54beda;");
        singleMode.setText("Single Mode");

        multiMode.setLayoutX(276.0);
        multiMode.setLayoutY(123.0);
        multiMode.setMnemonicParsing(false);
        multiMode.setPrefHeight(25.0);
        multiMode.setPrefWidth(158.0);
        multiMode.setStyle("-fx-background-color: #54beda;");
        multiMode.setText("Multi Mode");

        label.setLayoutX(109.0);
        label.setLayoutY(28.0);
        label.setPrefHeight(43.0);
        label.setPrefWidth(287.0);
        label.setText("Please Select Your Mode");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Berlin Sans FB", 24.0));

        anchorPane0.getChildren().add(singleMode);
        anchorPane0.getChildren().add(multiMode);
        anchorPane0.getChildren().add(label);
        anchorPane.getChildren().add(anchorPane0);

        handler.setScene(anchorPane);
        primaryStage.show();

        singleMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("abdo awd single mode");
                    handler.setScene("/singlemode/SingleMode.fxml", "single mode ", 800, 500, true);
                } catch (IOException ex) {
                    Logger.getLogger(SelectModeBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        multiMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("abdo awd multiModeAction");

                try {
                    System.out.println("abdo awd multiModeAction");

                    handler.setScene("/sinup/signup.fxml", " Sign Up ", 800, 800, true);
                } catch (IOException ex) {
                    Logger.getLogger(SelectModeBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void init() {

    }
}

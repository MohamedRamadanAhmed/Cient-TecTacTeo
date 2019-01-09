package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class NewModeBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final Button sigleBtn;
    protected final Button multiBtn;
    protected final Label label;

    public NewModeBase(Stage primarystage) {

        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        sigleBtn = new Button();
        multiBtn = new Button();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(600.0);
        anchorPane.setStyle("-fx-background-color: #010226;");

        anchorPane0.setLayoutX(44.0);
        anchorPane0.setLayoutY(100.0);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(523.0);
        anchorPane0.setStyle("-fx-background-color: #a90226;");

        sigleBtn.setLayoutX(84.0);
        sigleBtn.setLayoutY(123.0);
        sigleBtn.setMnemonicParsing(false);
        sigleBtn.setPrefHeight(25.0);
        sigleBtn.setPrefWidth(158.0);
        sigleBtn.setStyle("-fx-background-color: #54beda;");
        sigleBtn.setText("Single Mode");
        sigleBtn.setOnAction((event) -> new SingleMode(primarystage));

        multiBtn.setLayoutX(276.0);
        multiBtn.setLayoutY(123.0);
        multiBtn.setMnemonicParsing(false);
        multiBtn.setPrefHeight(25.0);
        multiBtn.setPrefWidth(158.0);
        multiBtn.setStyle("-fx-background-color: #54beda;");
        multiBtn.setText("Multi Mode");
        multiBtn.setOnAction((event) -> new LoginGUIClass(primarystage));

        label.setLayoutX(109.0);
        label.setLayoutY(28.0);
        label.setPrefHeight(43.0);
        label.setPrefWidth(287.0);
        label.setText("Please Select Your Mode");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Berlin Sans FB", 24.0));

        anchorPane0.getChildren().add(sigleBtn);
        anchorPane0.getChildren().add(multiBtn);
        anchorPane0.getChildren().add(label);
        anchorPane.getChildren().add(anchorPane0);
        getChildren().add(anchorPane);

    }
}

package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.Utils;

public class SinUp extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final Button btnSinUp;
    protected final Button btnLogIn;
    protected final Label labelSinUp;
    protected final Label labeOr;
    protected final PasswordField confirmPasswordField;
    protected final PasswordField passwordField;
    protected final TextField tfEmail;
    public final TextField tfName;
   public  Stage primaryStage ;

    public SinUp(Stage PrimaryStage) {
        this.primaryStage=PrimaryStage;
 PrimaryStage.getScene().setRoot(this);
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        btnSinUp = new Button();
        btnLogIn = new Button();
        labelSinUp = new Label();
        labeOr = new Label();
        confirmPasswordField = new PasswordField();
        passwordField = new PasswordField();
        tfEmail = new TextField();
        tfName = new TextField();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(600.0);
        anchorPane.setStyle("-fx-background-color: #010226;");

        anchorPane0.setLayoutX(83.0);
        anchorPane0.setLayoutY(49.0);
        anchorPane0.setPrefHeight(292.0);
        anchorPane0.setPrefWidth(428.0);
        anchorPane0.setStyle("-fx-background-color: #a90226;");

        btnSinUp.setLayoutX(79.0);
        btnSinUp.setLayoutY(246.0);
        btnSinUp.setMnemonicParsing(false);
        btnSinUp.setPrefHeight(25.0);
        btnSinUp.setPrefWidth(125.0);
        btnSinUp.setStyle("-fx-background-color: #54beda;");
        btnSinUp.setText("Sign up");

        btnLogIn.setLayoutX(214.0);
        btnLogIn.setLayoutY(20.0);
        btnLogIn.setMnemonicParsing(false);
        btnLogIn.setPrefHeight(25.0);
        btnLogIn.setPrefWidth(125.0);
        btnLogIn.setStyle("-fx-background-color: #54beda;");
        btnLogIn.setText("Log in");
        btnLogIn.setOnAction((event) -> new LoginGUIClass(PrimaryStage));

        labelSinUp.setLayoutX(74.0);
        labelSinUp.setLayoutY(14.0);
        labelSinUp.setPrefHeight(25.0);
        labelSinUp.setPrefWidth(104.0);
        labelSinUp.setText("Sign up");
        labelSinUp.setTextFill(javafx.scene.paint.Color.valueOf("#fcf9f9"));
        labelSinUp.setFont(new Font("Berlin Sans FB", 27.0));

        labeOr.setLayoutX(165.0);
        labeOr.setLayoutY(17.0);
        labeOr.setPrefHeight(25.0);
        labeOr.setPrefWidth(68.0);
        labeOr.setText("Or");
        labeOr.setTextFill(javafx.scene.paint.Color.valueOf("#fffefe"));
        labeOr.setFont(new Font("Berlin Sans FB", 27.0));

        confirmPasswordField.setLayoutX(79.0);
        confirmPasswordField.setLayoutY(204.0);
        confirmPasswordField.setPrefHeight(25.0);
        confirmPasswordField.setPrefWidth(262.0);
        confirmPasswordField.setPromptText("Confirm Password");

        passwordField.setLayoutX(79.0);
        passwordField.setLayoutY(157.0);
        passwordField.setPrefHeight(25.0);
        passwordField.setPrefWidth(262.0);
        passwordField.setPromptText("Enter Password");

        tfEmail.setLayoutX(79.0);
        tfEmail.setLayoutY(106.0);
        tfEmail.setPrefHeight(25.0);
        tfEmail.setPrefWidth(262.0);
        tfEmail.setPromptText("Enter Your E-mail");

        tfName.setLayoutX(79.0);
        tfName.setLayoutY(59.0);
        tfName.setPrefHeight(25.0);
        tfName.setPrefWidth(262.0);
        tfName.setPromptText("Enter Your User Name");

        anchorPane0.getChildren().add(btnSinUp);
        anchorPane0.getChildren().add(btnLogIn);
        anchorPane0.getChildren().add(labelSinUp);
        anchorPane0.getChildren().add(labeOr);
        anchorPane0.getChildren().add(confirmPasswordField);
        anchorPane0.getChildren().add(passwordField);
        anchorPane0.getChildren().add(tfEmail);
        anchorPane0.getChildren().add(tfName);
        anchorPane.getChildren().add(anchorPane0);
        getChildren().add(anchorPane);
        btnSinUp.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent event) {
         
         
                     if (tfName.getText().trim().isEmpty()) {
                Utils.showAlert(Alert.AlertType.ERROR, anchorPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                return;
            }
            if (!(Utils.validate(tfEmail.getText()))) {
                Utils.showAlert(Alert.AlertType.ERROR, anchorPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                return;
            }
            if (passwordField.getText().trim().isEmpty() || passwordField.getText().trim().length() <= 7) {
                Utils.showAlert(Alert.AlertType.ERROR, anchorPane.getScene().getWindow(), "Form Error!", "password must be 8 digits at least");
                return;
            }
            if (!(passwordField.getText().equals(confirmPasswordField.getText()))) {
                Utils.showAlert(Alert.AlertType.ERROR, anchorPane.getScene().getWindow(), "Form Error!", "password not confirmed");
                return;
            }
            Player l = new Player(tfName.getText(),tfEmail.getText(),passwordField.getText());
         
            SingleMode mode=new SingleMode(primaryStage);

           
     }
 });

    }
}

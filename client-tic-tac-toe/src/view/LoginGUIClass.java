package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginGUIClass extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final Button loginBtn;
    protected final PasswordField passwordField;
    protected final TextField textField;
    protected final Label label;
    protected final Button signUpBtn;

    public LoginGUIClass(Stage PrimaryStage) {
        PrimaryStage.getScene().setRoot(this);
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        loginBtn = new Button();
        passwordField = new PasswordField();
        textField = new TextField();
        label = new Label();
        signUpBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        anchorPane.setPrefHeight(401.0);
        anchorPane.setPrefWidth(600.0);
        anchorPane.setStyle("-fx-background-color: #010226;");

        anchorPane0.setLayoutX(94.0);
        anchorPane0.setLayoutY(58.0);
        anchorPane0.setPrefHeight(281.0);
        anchorPane0.setPrefWidth(432.0);
        anchorPane0.setStyle("-fx-background-color: #a90226;");

        loginBtn.setLayoutX(77.0);
        loginBtn.setLayoutY(198.0);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(25.0);
        loginBtn.setPrefWidth(131.0);
        loginBtn.setStyle("-fx-background-color: #54beda;");
        loginBtn.setText("Log In");
        loginBtn.setOnAction((event) -> new LoginGUIClass(PrimaryStage));

        passwordField.setLayoutX(77.0);
        passwordField.setLayoutY(133.0);
        passwordField.setPrefHeight(33.0);
        passwordField.setPrefWidth(276.0);
        passwordField.setPromptText("Password");

        textField.setLayoutX(77.0);
        textField.setLayoutY(70.0);
        textField.setPrefHeight(33.0);
        textField.setPrefWidth(276.0);
        textField.setPromptText("User Name");

        label.setLayoutX(148.0);
        label.setLayoutY(24.0);
        label.setPrefHeight(25.0);
        label.setPrefWidth(111.0);
        label.setText("Log in ");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fffefe"));
        label.setFont(new Font("Berlin Sans FB", 27.0));

        signUpBtn.setLayoutX(222.0);
        signUpBtn.setLayoutY(198.0);
        signUpBtn.setMnemonicParsing(false);
        signUpBtn.setPrefHeight(25.0);
        signUpBtn.setPrefWidth(131.0);
        signUpBtn.setStyle("-fx-background-color: #54beda;");
        signUpBtn.setText("Sign Up");
        signUpBtn.setOnAction((event) -> new SinUp(PrimaryStage));

        anchorPane0.getChildren().add(loginBtn);
        anchorPane0.getChildren().add(passwordField);
        anchorPane0.getChildren().add(textField);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(signUpBtn);
        anchorPane.getChildren().add(anchorPane0);
        getChildren().add(anchorPane);

    }
}

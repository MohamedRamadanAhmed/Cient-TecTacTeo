package replacedclasses;

import client.server.remote.interfaces.UserAccountHandler;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.Utils;

public class Login extends AnchorPane {

    public Stage primaryStage;
    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final Button loginBtn;
    protected final PasswordField passwordField;
    protected final TextField tfName;
    protected final Label label;
    protected final Button signUpBtn;

    public Login(Stage PrimaryStage) {
        PrimaryStage.getScene().setRoot(this);
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        loginBtn = new Button();
        passwordField = new PasswordField();
        tfName = new TextField();
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
        loginBtn.setOnAction((event) -> {
            UserAccountHandler accountHandler = null;
            try {
              //  accountHandler = Utils.establishConnection();
                
               // accountHandler.login("aa@a.com", "1111")) {
                    Stage selectMode = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("MultiMode.fxml"));

                    Utils.switchWindow(root);
//                if (accountHandler.login("aa@a.com", "1111")) {
//                    Stage selectMode = new Stage();
//                    Parent root = FXMLLoader.load(getClass().getResource("MultiMode.fxml"));
//                    Scene scene = new Scene(root);
//                    selectMode.setScene(scene);
//                    selectMode.initStyle(StageStyle.UNDECORATED);
//                    selectMode.show();
//                } else {
//                    Utils.showAlert(Alert.AlertType.ERROR, PrimaryStage, "error", "");
//
//                }

            } catch (RemoteException ex) {
                Utils.showAlert(Alert.AlertType.ERROR, PrimaryStage, "server is un available", "try again later");
            } catch (IOException ex) {
                System.err.println("IOException");
            }

        });

        passwordField.setLayoutX(77.0);
        passwordField.setLayoutY(133.0);
        passwordField.setPrefHeight(33.0);
        passwordField.setPrefWidth(276.0);
        passwordField.setPromptText("Password");

        tfName.setLayoutX(77.0);
        tfName.setLayoutY(70.0);
        tfName.setPrefHeight(33.0);
        tfName.setPrefWidth(276.0);
        tfName.setPromptText("User Name");

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
        signUpBtn.setOnAction((event) -> {
            try {

                utils.Utils.switchWindow(FXMLLoader.load(getClass().getResource("/sinup/signup.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        anchorPane0.getChildren().add(loginBtn);
        anchorPane0.getChildren().add(passwordField);
        anchorPane0.getChildren().add(tfName);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(signUpBtn);
        anchorPane.getChildren().add(anchorPane0);
        getChildren().add(anchorPane);

    }
}

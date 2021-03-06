/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinup;

import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import utils.Connection;
import utils.SceneHandler;
import utils.Utils;

public class SignupController implements Initializable {

    SceneHandler handler = SceneHandler.getInstance();

    @FXML
    private Button btnSignUp;
    @FXML
    private Button btnLogin;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXTextField txtEmailAddress;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void signupAction(ActionEvent event) throws IOException {
        System.out.println("sin up was clicked ");
        try {
            if (!(Utils.validateName(txtUserName.getText()))) {
                Utils.showAlert(Alert.AlertType.ERROR, btnSignUp.getScene().getWindow(), "Sin up  Error!", "Please enter valid  name");
                return;
            }
            if (!(Utils.validateEmail(txtEmailAddress.getText()))) {
                Utils.showAlert(Alert.AlertType.ERROR, btnSignUp.getScene().getWindow(), "Sin up  Error!", "Please enter valid email address");
                return;

            }
            if (txtPassword.getText().trim().isEmpty() || txtPassword.getText().trim().length() <= 3) {
                Utils.showAlert(Alert.AlertType.ERROR, btnSignUp.getScene().getWindow(), "Sin up  Error!", "password must be 3 digits at least");
                return;
            }
            if (!(txtConfirmPassword.getText().equals(txtConfirmPassword.getText()))) {
                Utils.showAlert(Alert.AlertType.ERROR, btnSignUp.getScene().getWindow(), "Sin up  Error!", "password not confirmed");
                return;

            }
            if (!Connection.isConneted()) {
                Utils.showAlert(Alert.AlertType.ERROR, btnSignUp.getScene().getWindow(), "Sin up  Error!", "check internet connection");
                return;

            }
            UserAccountHandler accountHandler = Utils.establishConnection();
            if (accountHandler.signUp(new UserModel(txtUserName.getText(), txtEmailAddress.getText(), txtPassword.getText(), "1111"))) {
                handler.setScene("/login/login.fxml", "login", 500, 500, true);

            } else {
                System.out.println("else sin up ");
                Utils.showAlert(Alert.AlertType.ERROR, btnSignUp.getScene().getWindow(), "sin up error", "this email address already exists ");
            }
        } catch (RemoteException ex) {
            Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "server is un available", "try again later");

        } catch (IOException ex) {
            Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "server is un available", "try again later");

        } catch (NotBoundException ex) {
            Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "server is un available", "try again later");

        }

    }

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {

        handler.setScene("/login/login.fxml", "Sign in", 500, 500, true);
    }

    @FXML
    private void handlePlayNowAction(ActionEvent event) throws IOException {

        handler.setScene("/singlemode/SingleMode.fxml", "Single Mode", 800, 500, true);

    }

}

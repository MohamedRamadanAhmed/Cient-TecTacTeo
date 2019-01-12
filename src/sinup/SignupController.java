/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinup;

import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.Utils;

public class SignupController implements Initializable {

    @FXML
    private Button btnSignup;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField userName;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private PasswordField tfConfrmPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void signupAction(ActionEvent event) {
        btnSignup.setOnAction(ev -> {

            try {
                if (!(Utils.validateName(userName.getText()))) {
                    Utils.showAlert(Alert.AlertType.ERROR, btnSignup.getScene().getWindow(), "Sin up  Error!", "Please enter valid  name");
                    return;
                }
                if (!(Utils.validateEmail(tfEmail.getText()))) {
                    Utils.showAlert(Alert.AlertType.ERROR, btnSignup.getScene().getWindow(), "Sin up  Error!", "Please enter valid email address");
                    return;
                }
                if (tfPassword.getText().trim().isEmpty() || tfPassword.getText().trim().length() <= 3) {
                    Utils.showAlert(Alert.AlertType.ERROR, btnSignup.getScene().getWindow(), "Sin up  Error!", "password must be 3 digits at least");
                    return;
                }
                if (!(tfPassword.getText().equals(tfConfrmPassword.getText()))) {
                    Utils.showAlert(Alert.AlertType.ERROR, btnSignup.getScene().getWindow(), "Sin up  Error!", "password not confirmed");
                    return;
                }

                UserAccountHandler accountHandler = Utils.establishConnection();
                if(accountHandler.signUp(new UserModel(userName.getText(), tfEmail.getText(), tfPassword.getText(), Utils.getIpAddress()))){
                   Parent root = FXMLLoader.load(getClass().getResource("MultiMode.fxml"));
                Utils.switchWindow(root);
                System.out.println("sin up was clicked "); 
                }
                else
                {
                Utils.showAlert(Alert.AlertType.ERROR, btnSignup.getScene().getWindow(), "sin up error", "this email address already exists ");
                }
                
            } catch (RemoteException | UnknownHostException ex) {
                // Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //  Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        btnSignup.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
        Utils.switchWindow(root);

    }

}

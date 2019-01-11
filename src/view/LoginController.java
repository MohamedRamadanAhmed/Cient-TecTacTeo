package view;

import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
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

public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSignup;
    @FXML
    private TextField tfName;
    @FXML
    private PasswordField tfPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException, NotBoundException {

        try {
            UserAccountHandler accountHandler;
            accountHandler = Utils.establishConnection();
            UserModel model = accountHandler.login("aa@a.com", "1111");
            Utils.setCurrentUser(model);
            System.out.println(model.getEmailAddress() + "model");

            if (model != null) {
                Parent root = FXMLLoader.load(getClass().getResource("MultiMode.fxml"));
                utils.Utils.switchWindow(root);

            } else {
                System.out.println(model.getEmailAddress() + "user model = null");

                Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "error", "login return null ");
            }

        } catch (RemoteException ex) {
            ex.printStackTrace();
            Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "server is un available", "try again later");
        } catch (IOException ex) {
            System.err.println("IOException");

            Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "server is un available", "try again later");
        }
    }

    @FXML
    private void signupAction(ActionEvent event) throws IOException {
        btnLogin.getScene().getWindow().hide();
        utils.Utils.switchWindow(FXMLLoader.load(getClass().getResource("signup.fxml")));

    }

}

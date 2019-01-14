package login;

import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.ClintImp;
import utils.SceneHandler;
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
    private SceneHandler handler = SceneHandler.getInstance();
    Utils util = new Utils();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML

    private void loginAction(ActionEvent event) throws IOException {

        try {
            UserAccountHandler accountHandler;
            accountHandler = Utils.establishConnection();

            ClintImp clintImp = new ClintImp();
            UserModel model = accountHandler.login(clintImp, "abdo@a.com", "1111");
            Utils.setCurrentUser(model);
            System.out.println(model.getEmailAddress() + "model");

            if (model != null) {
                //Parent root = FXMLLoader.load(getClass().getResource("/multimode/MultiMode.fxml"));
                //utils.Utils.switchWindow(root);
                //handler.setScene(root);
                handler.setScene("/multimode/MultiMode.fxml", "hg", 800, 800, true);
            } else {
                System.out.println(model.getEmailAddress() + "user model = null");

                Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "error", "login return null ");
            }

        } catch (RemoteException ex) {

            Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "server is un available", "try again later");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("IOException");

            Utils.showAlert(Alert.AlertType.ERROR, btnLogin.getScene().getWindow(), "server is un available", "try again later");

        } catch (NotBoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void signupAction(ActionEvent event) throws IOException {
//        btnLogin.getScene().getWindow().hide();
        handler.setScene("/sinup/signup.fxml", "hg", 800, 800, true);

        //utils.Utils.switchWindow(FXMLLoader.load(getClass().getResource("/sinup/signup.fxml")));

    }

}

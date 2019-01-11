
package view;

import client.server.remote.interfaces.UserAccountHandler;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private void loginAction(ActionEvent event) throws IOException {
        
           try {
               UserAccountHandler accountHandler = Utils.establishConnection();
                
                accountHandler.login("aa@a.com", "1111") ;
                    Parent root = FXMLLoader.load(getClass().getResource("MultiMode.fxml"));
                    utils.Utils.switchWindow(root);
                    

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

            } catch (IOException ex) {
                System.err.println("IOException");
                ex.printStackTrace();
            } catch (NotBoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void signupAction(ActionEvent event) throws IOException {
         btnLogin.getScene().getWindow().hide();
         
         
          
                utils.Utils.switchWindow(FXMLLoader.load(getClass().getResource("signup.fxml")));
        

    }
    
}

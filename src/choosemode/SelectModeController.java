/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choosemode;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utils.Utils;

public class SelectModeController implements Initializable {

    @FXML
    private Button singleMode;
    @FXML
    private Button multiMode;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }

    @FXML
    private void singleModeAction(ActionEvent event) throws IOException {
        multiMode.getScene().getWindow().hide();
        
        Parent root = FXMLLoader.load(getClass().getResource("/singlemode/SingleMode.fxml"));
            Utils.switchWindow(root);
    }

    @FXML
    private void multiModeAction(ActionEvent event) throws IOException {
        singleMode.getScene().getWindow().hide();
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/sinup/signup.fxml"));
            Utils.switchWindow(root);
        } catch (IOException ex) {
            
        }
       
    }

}

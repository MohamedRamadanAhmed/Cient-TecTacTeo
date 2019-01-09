/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import utils.Utils;

public class MultiModeController implements Initializable {

    
    UserAccountHandler accountHandler=null;
    @FXML
    private Label user1;
    @FXML
    private Label user2;
    @FXML
    private Button startgame;
    @FXML
    private Button exit;
    @FXML
    private Button record;
    @FXML
    private Button back;
    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            accountHandler=Utils.establishConnection();
//      
//            ArrayList<UserModel> list;
//             list = (ArrayList<UserModel>) accountHandler.getOnlinePlayer();
//             System.out.println(list.get(0).getEmailAddress());
////            for (UserModel model :list ) {
////             
////                 listView.getItems().addAll(model.getUserName());
////            }
//        
//           
//        } catch (RemoteException ex) {
//            Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NotBoundException ex) {
//            Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
    }

    @FXML
    private void startGameAction(ActionEvent event) {
    }

    @FXML
    private void exitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void recordAction(ActionEvent event) {
//        try {
//            //listView.getItems().add(exit);
//            accountHandler=Utils.establishConnection();
//            ArrayList<UserModel> list=(ArrayList<UserModel>) accountHandler.getOnlinePlayer();
//            for (UserModel model :list ) {
//             
//                 //listView.getItems().addAll(model.);
//            }
           
            
            
//              listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<UserModel>() {
//            @Override
//            public void changed(ObservableValue<? extends UserModel> observable, UserModel oldValue, UserModel newUser) {
//                System.out.println("Selected item: " + newUser.getEmailAddress());
//            }
//         
//        });
//        } catch (RemoteException ex) {
//            Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NotBoundException ex) {
//            Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
      
    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        exit.getScene().getWindow().hide();
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SelectMode.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
    }

}

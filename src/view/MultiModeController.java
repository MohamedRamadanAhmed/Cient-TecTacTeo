/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import utils.Utils;

public class MultiModeController implements Initializable {

    UserAccountHandler accountHandler = null;
    @FXML
    private Label user1;
    @FXML
    private Label user2;
    @FXML
    private Button startgame;
    @FXML
    private Button exit;
    @FXML
    private Button btnLogout;
    @FXML
    private Button record;
    @FXML
    private Button back;
    @FXML
    private JFXListView<UserModel> listView;
    //ObservableList<UserModel> list;

    UserAccountHandler accountHandler1;

    public ObservableList<UserModel> mylistview = FXCollections.observableArrayList(new UserModel("abdo", "abdo", "abdo", "abdo"),
            new UserModel("awd", "awd", "awd", "awd"), new UserModel("mohamed", "mohamed", "mohamed", "mohamed"),
            new UserModel("mahmoud", "mahmoud", "mahmoud", "mahmoud"));
    UserModel model ;

    public MultiModeController() {
    }

    class Cell extends ListCell<UserModel> {

        HBox hbox = new HBox();
        Button btn = new Button("Delete");
        Label label = new Label("");
        Pane pane = new Pane();
        //  Image profile = new Image("images/tic-tac-toe.png");
        // ImageView img = new ImageView(profile);

        public Cell() {
            super();
            new MultiModeController();
            hbox.getChildren().addAll(label, pane, btn);
            hbox.setHgrow(pane, Priority.ALWAYS);
            listView.setOnMouseClicked(event -> {
                model = listView.getSelectionModel().getSelectedItem();
                int x= listView.getSelectionModel().getSelectedIndex();
                System.out.println(model.getEmailAddress());
                                System.out.println(x);

            
                    });

        }

        @Override
        protected void updateItem(UserModel item, boolean empty) {
            super.updateItem(item, empty);

            setText(null);
            setGraphic(null);
            if (item != null && !empty) {
                label.setText(item.getUserName());
                setGraphic(hbox);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//         //   accountHandler = Utils.establishConnection();
////            list = (ObservableList<UserModel>) accountHandler.getOnlinePlayer();
//            System.out.println(list.size() + "list size ");
//        } catch (RemoteException ex) {
//            Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NotBoundException ex) {
//            Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        listView.setItems(mylistview);
        GridPane pane = new GridPane();
        Label name = new Label("gg");
        Button btn = new Button("dd");
        pane.add(name, 0, 0);
        pane.add(btn, 0, 1);
        listView.setCellFactory(param -> new Cell());

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

    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        exit.getScene().getWindow().hide();

        Utils.switchWindow(FXMLLoader.load(getClass().getResource("SelectMode.fxml")));

    }

    @FXML
    void logOutAction(ActionEvent event) throws RemoteException, IOException {
//        accountHandler.logOut(new UserModel("", "", "aa@a.com", ""));
        btnLogout.getScene().getWindow().hide();
        Utils.switchWindow(FXMLLoader.load(getClass().getResource("signup.fxml")));
// go to login again 
    }

}

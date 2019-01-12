/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlemode;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import model.TicTacTocGame;

public class SingleModeController implements Initializable {

    @FXML
    private Button goOnline;
    @FXML
    private Button record;
    @FXML
    private Button back;

    @FXML
    public Label lblCell1;

    @FXML
    public Label lblCell4;

    @FXML
    public Label lblCell7;

    @FXML
    public Label lblCell2;

    @FXML
    public Label lblCell5;

    @FXML
    public Label lblCell8;

    @FXML
    public Label lblCell3;

    @FXML
    public Label lblCell6;

    @FXML
    public Label lblCell9;
    
    @FXML
    private Label username;
    public static String userName = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
              TicTacTocGame game = new TicTacTocGame(this);
              while (userName.equals("")) {
            userName = JOptionPane.showInputDialog("please enter your name = ");
        }
                      lblCell1.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell1, 0));
                              lblCell2.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell2, 1));
                                      lblCell3.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell3, 2));

        lblCell4.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell4, 3));
        lblCell5.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell5, 4));
        lblCell6.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell6, 5));
        lblCell7.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell7, 6));
        lblCell8.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell8, 7));
        lblCell9.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell9, 8));



    }

    @FXML
    private void goOnlineAction(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("MultiMode.fxml"));
        utils.Utils.switchWindow(root);

    }

    @FXML
    private void recordAction(ActionEvent event) {

    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        goOnline.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("SelectMode.fxml"));
        utils.Utils.switchWindow(root);
    }

}

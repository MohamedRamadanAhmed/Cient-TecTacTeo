/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlemode;

import demo.MoveContent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import main.XMLRecord;
import model.ClintImp;
import model.TicTacTocGame;
import utils.SceneHandler;

public class SingleModeController implements Initializable {

    @FXML
    private Button goOnline;
    @FXML
    public Button play;
  
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
    @FXML
    public Label numMatch;

    @FXML
    public Label userScoreLbl;
    TicTacTocGame game;
    SceneHandler handler = SceneHandler.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        game = new TicTacTocGame(this);
        while (userName.equals("")) {
            userName = JOptionPane.showInputDialog("please enter your name : ");
        }
        username.setText(userName);
        lblCell1.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell1, 0));
        lblCell2.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell2, 1));
        lblCell3.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell3, 2));

        lblCell4.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell4, 3));
        lblCell5.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell5, 4));
        lblCell6.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell6, 5));
        lblCell7.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell7, 6));
        lblCell8.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell8, 7));
        lblCell9.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell9, 8));
        numMatch.setText(game.getGameNum() + "");
        userScoreLbl.setText(game.getScore() + "");
        play.setVisible(false);
        
       

    }

    @FXML
    private void goOnlineAction(ActionEvent event) throws IOException {
       try {
           
        userName="";
        game.setScore(0);
        game.setGameNum(0);
            handler.setScene("/login/login.fxml", " Single Mode", 800, 800, true);
        } catch (IOException ex) {
            Logger.getLogger(SingleModeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



      @FXML
    void playAction(ActionEvent event) {
        try {
            handler.setScene("/singlemode/SingleMode.fxml", " Single Mode", 800, 800, true);
        } catch (IOException ex) {
            Logger.getLogger(SingleModeController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

}

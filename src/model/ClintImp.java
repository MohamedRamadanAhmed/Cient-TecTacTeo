package model;

import client.server.remote.interfaces.ClientInterface;
import client.server.remote.interfaces.Step;
import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import multimode.MultiModeController;
import multimode.MyControoler;
import utils.Utils;

public class ClintImp extends UnicastRemoteObject implements ClientInterface {

    UserAccountHandler accountHandler;
    MyControoler controoler = new MyControoler();

    public ClintImp() throws RemoteException, NotBoundException {
        accountHandler = Utils.establishConnection();
    }

    @Override
    public boolean requestGame(UserModel model1, UserModel player2) throws RemoteException {
        System.out.println("ay haga");
        int x = JOptionPane.showConfirmDialog(null, model1.getUserName());
        if (x == 0) {
            Utils.setPlayer(model1);
            return true;

        } else {
            return false;
        }
    }

    @Override
    public void startGame(UserModel player1, UserModel player2) throws RemoteException {
        controoler.startGame();
    }

    @Override
    public void drawMove(Step s) throws RemoteException {

        MyControoler.drawMove(s);

    }

}

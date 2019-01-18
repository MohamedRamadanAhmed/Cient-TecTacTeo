package model;

import client.server.remote.interfaces.ClientInterface;
import client.server.remote.interfaces.Step;
import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
import multimode.MultiModeController;
import multimode.MyControoler;

import utils.Utils;

public class ClintImp extends UnicastRemoteObject implements ClientInterface {

    UserAccountHandler accountHandler;
    MyControoler controoler = new MyControoler();
    public static boolean isReceving;

    public ClintImp() throws RemoteException, NotBoundException {

        accountHandler = Utils.establishConnection();
    }

    @Override
    public boolean requestGame(UserModel model1, UserModel player2) throws RemoteException {
        int x = JOptionPane.showConfirmDialog(null, model1.getUserName());

        if (x == 0) {
            Utils.setPlayer(model1);
            Utils.setSymbol("o");
            Utils.isMyTurn = false;
            return true;

        } else {
            return false;
        }
    }

    @Override
    public void startGame(UserModel player1, UserModel player2) throws RemoteException {
        controoler.startGame();

        MultiModeController.getInstance().startgame();
    }

    @Override
    public void drawMove(Step step) throws RemoteException {
        //  controoler.drawMove(step);
//        controoler.dra(step);
        controoler.setStep(step);
        isReceving = true;
        MultiModeController.getInstance().receive(step);
    }

    @Override
    public void receiverMessage(UserModel player1, String message) throws RemoteException {
        MultiModeController.getInstance().print(player1, message);
    }
}

package model;

import client.server.remote.interfaces.ClientInterface;
import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import utils.Utils;

public class ClintImp extends UnicastRemoteObject implements ClientInterface {

    UserAccountHandler accountHandler;

    public ClintImp() throws RemoteException, NotBoundException {
        accountHandler = Utils.establishConnection();

    }

    @Override
    public boolean requestGame(UserModel model1, UserModel player2) throws RemoteException {
        if (Utils.showRequestDialouge(player2.getUserName())) {
            return true;
        }
        return false;

    }

    @Override
    public void startGame(UserModel player1, UserModel player2) throws RemoteException {

    }

}

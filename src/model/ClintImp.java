package model;

import client.server.remote.interfaces.ClientInterface;
import client.server.remote.interfaces.UserModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import utils.Utils;

public class ClintImp extends UnicastRemoteObject implements ClientInterface {

    public ClintImp() throws RemoteException {

    }

    @Override
    public boolean requestGame(UserModel model1, UserModel player2) throws RemoteException {
        if (Utils.showRequestDialouge(player2.getUserName())) {

        } else {

        }
        return false;

    }

    @Override
    public void startGame(UserModel player1, UserModel player2) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

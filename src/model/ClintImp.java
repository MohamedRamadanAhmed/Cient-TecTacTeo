package model;

import client.server.remote.interfaces.ClientInterface;
import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
import utils.Utils;

public class ClintImp extends UnicastRemoteObject implements ClientInterface {

    UserAccountHandler accountHandler;

    public ClintImp() throws RemoteException, NotBoundException {
        
        accountHandler = Utils.establishConnection();
    }

    @Override
    public boolean requestGame(UserModel model1, UserModel player2) throws RemoteException {
        System.out.println("ay haga");
        int x=JOptionPane.showConfirmDialog(null, player2.getUserName());
        if( x==0){
             return true;
        }
        else 
            return false;
     
        
    }

    @Override
    public void startGame(UserModel player1, UserModel player2) throws RemoteException {
        System.out.println("ee"+player2.getUserName());
       
    }

}

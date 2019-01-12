/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author Abdelrahman
 */
public class MyControoler {

    static UserAccountHandler accountHandler = null;

    public static boolean logOut() throws RemoteException, NotBoundException {

      return accountHandler.logOut(Utils.getCurrentUser().getEmailAddress());
    }

    public static void requestGame(UserModel selectedItem) throws RemoteException, NotBoundException {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            accountHandler = Utils.establishConnection();
                            try {
                                accountHandler.requestGame(Utils.getCurrentUser(), selectedItem);
                            } catch (RemoteException ex) {
                                Logger.getLogger(MyControoler.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } catch (RemoteException ex) {
                            Logger.getLogger(MyControoler.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NotBoundException ex) {
                            Logger.getLogger(MyControoler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                };
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }

                // UI update is run on the Application thread
                Platform.runLater(updater);

            }

        });
        thread.setDaemon(true);
        thread.start();

    }

}

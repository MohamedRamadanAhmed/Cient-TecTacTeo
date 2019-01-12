/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimode;

import client.server.remote.interfaces.Step;
import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import utils.Utils;

public class MyControoler {

    static void transmitMove(int i, String x, UserModel model) {
        try {
            accountHandler = Utils.establishConnection();
            accountHandler.transmitMove(new Step(model.getEmailAddress(), i, x));
        } catch (RemoteException ex) {
            Logger.getLogger(MyControoler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MyControoler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void drawMove(Step s) {

        System.out.println(s.getDraw());
        System.out.println(s.getPlayer());
        System.out.println(s.getPosition());

    }

    MultiModeController multiModeController = new MultiModeController();

    public void startGame() {
        Utils.isPlaying = true;

    }

    boolean accept = false;

    static UserAccountHandler accountHandler = null;

    public static boolean logOut() throws RemoteException, NotBoundException {
        accountHandler = Utils.establishConnection();
        return accountHandler.logOut(Utils.getCurrentUser().getEmailAddress());
    }

    public static void requestGame(UserModel selectedItem) throws RemoteException, NotBoundException {

        Thread thread;
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater;
                updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            accountHandler = Utils.establishConnection();
                            try {
                                if (accountHandler.requestGame(Utils.getCurrentUser(), selectedItem)) {
                                    System.err.println("accept");
                                } else {
                                    System.err.println("refused");
                                }
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
                    Thread.sleep(500);
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

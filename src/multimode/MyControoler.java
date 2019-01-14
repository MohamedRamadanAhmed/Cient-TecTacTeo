package multimode;

import client.server.remote.interfaces.Step;
import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import model.ClintImp;
//import static multimode.MultiModeController.lable1;
import utils.Utils;

public class MyControoler {

    Utils util = new Utils();
    static UserAccountHandler accountHandler = null;

    private Step step;
    FXMLLoader fxmlLoader = new FXMLLoader();
    Pane p;
    MultiModeController multiModeController;
    
    public static boolean logOut() throws RemoteException, NotBoundException {
        return accountHandler.logOut(Utils.getCurrentUser().getEmailAddress());
    }

    public MyControoler() {

    }

    static void transmitMove(int i, String x, UserModel model) {
        try {

            accountHandler = Utils.establishConnection();
            accountHandler.transmitMove(new Step(model.getEmailAddress(), Utils.getCurrentUser().getEmailAddress(), i, x));
        } catch (RemoteException ex) {
            Logger.getLogger(MyControoler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MyControoler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setStep(Step step) {
        this.step = step;
    
        System.out.println(step.draw);
        System.out.println(step.position);
        System.out.println(step.player);
    }

    public Step getStep() {
        return step;
    }

//    public void drawMove(Step s) {
//
//        if (s != null) {
//            try {
//                p = fxmlLoader.load(getClass().getResource("/multimode/MultiMode.fxml").openStream());
//                multiModeController = (MultiModeController) fxmlLoader.getController();
//                multiModeController.drawMove(s);
//            } catch (IOException ex) {
//                Logger.getLogger(MyControoler.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } else {
//
//            System.out.println(s.getDraw() + "object is null");
//        }
//    }
    public void startGame() {
        Utils.isPlaying = true;

    }

    boolean accept = false;

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

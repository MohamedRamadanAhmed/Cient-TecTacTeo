package utils;

import client.server.remote.interfaces.UserAccountHandler;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.regex.Matcher;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;
import view.SingleMode;

public class Utils {

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    public static void switchWindow(Stage window, Application app) {
        try {
            app.start(window);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean validate(String emailStr) {
        Matcher matcher = Constants.VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static UserAccountHandler establishConnection() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(Constants.SERVER_IP_ADDRESS, Constants.PORT);
        UserAccountHandler userAccountHandler = (UserAccountHandler) registry.lookup(Constants.ACCOUNT_SERVICE);
        return userAccountHandler;
    }
    public static String getIpAddress() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        // System.out.println("IP Address:- " + inetAddress.getHostAddress());
        return inetAddress.getHostAddress();
    }

}

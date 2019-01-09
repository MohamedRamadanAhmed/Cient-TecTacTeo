package view;
import client.server.remote.interfaces.UserAccountHandler;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static javafx.application.Application.launch;
import utils.Constants;
import view.TicTacToeProject;


public class Client {

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            Registry registry = LocateRegistry.getRegistry("10.0.0.247");
            //Registry registry = LocateRegistry.getRegistry(Constants.PORT);
            UserAccountHandler userAccountHandler = (UserAccountHandler) registry.lookup(Constants.ACCOUNT_SERVICE);
            System.out.println(userAccountHandler.login("JETS", "d"));
            TicTacToeProject game =new TicTacToeProject();
            game.launch();
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
package utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {

     // check internet connection
    public static boolean isConneted() {
        Process process = null;
        try {
            process = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org");
            int x = process.waitFor();
            if (x == 0) {
                return true;
            }

        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}

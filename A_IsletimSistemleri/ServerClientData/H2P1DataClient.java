package A_IsletimSistemleri.ServerClientData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;


/**
 * H2P1DataClient
 */
public class H2P1DataClient {
    public static void main(String[] args) throws IOException{
        String serverAdress ="127.0.0.1";
        Socket s = new Socket(serverAdress, 9091);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        s.close();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
    
}
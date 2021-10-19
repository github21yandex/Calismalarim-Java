package A_IsletimSistemleri.ServerClientData;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

public class H2P1DataServer {

    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(9091);

        

        while (true) {
            Socket socket = listener.accept();

            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Operating Systems Course");
                System.out.println("Date is written");
            } catch (Exception e) {
                listener.close();

            }

        }

        

    }

}

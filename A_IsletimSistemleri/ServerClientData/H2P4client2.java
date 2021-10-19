package A_IsletimSistemleri.ServerClientData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class H2P4client2 {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        BufferedReader in = null;

        try {
            //* server 'a localhost ve 7755 portu üzerinden başlantı sağlanıyor *//
            socket = new Socket("localhost", 7755);

        } catch (Exception e) {
            System.out.println("Port Hatası!");
        }

        //* Server'dan gelen verileri tutan BufferedReader nesnesi oluşturulur *//
        
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        System.out.println("Serverdan gelen sayi:" + in.readLine());
        in.close();

        
    }
}

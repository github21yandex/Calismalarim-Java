package A_IsletimSistemleri.ServerClientData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class H2P4client {
    public static void main(String[] args) throws IOException {
        

        Socket socket = null;
        BufferedReader in = null;
        String serverdanGelenCumle = null;
        PrintWriter out = null;

        try {
            //* server 'a localhost ve 7755 portu üzerinden başlantı sağlanıyor *//
            socket = new Socket("localhost", 7755);

        } catch (Exception e) {
            System.out.println("Port Hatası!");
        }

        //* Server'dan gelen verileri tutan BufferedReader nesnesi oluşturulur *//
        
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        // Server a veri göndermi için kullanılacak PrintWriter nesnesi oluşturulur

        out = new PrintWriter(socket.getOutputStream(), true);
      
        
        System.out.println("Serverdan gelen mesaj :" + in.readLine());

        //Yukarıdaki kodlar serverdan gelen sadece tek bir veriyi okur, Bunu sürekli
        //hale getirmek için while yapısı kullanılmalıdır
        
        try {
            while (!(serverdanGelenCumle = in.readLine()).equals("exit") ) {
                System.out.println("Client'dan gelen cumle : " + serverdanGelenCumle);
                out.println("mesaj alindi");
                
            }
        } catch (Exception e) {
            System.out.println("Bağlantı Hatası:" + e);
        }
        
        in.close();
        socket.close();

        
    }
}

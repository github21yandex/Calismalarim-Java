package A_IsletimSistemleri.DataServerMulti;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DataServerMulti {

    public static void main(String[] args) throws IOException, InterruptedException {

        
        ServerSocket listener = null;
        Socket clientSocket = null;
        
        

        try {
            // *Server 7755 portundan Client'ı dinliyor *//
            listener = new ServerSocket(7755);
        } catch (Exception e) {
            System.out.println("Port Hatası!");
        }
        System.out.println("SERVER BAĞLANTI İÇİN HAZIR...");

        
        while(true){
            clientSocket = listener.accept();
            Thread thrd = new Thread( new thrdListener(listener, clientSocket) );
            thrd.start();
            //thrd.join();
            
        }
                

    }

}

class thrdListener implements Runnable{
    String clientGelen;
    Socket clientSocket = null;
    int sayi;

    private ServerSocket listener;

    public thrdListener(ServerSocket listener, Socket clientSocket){
        this.listener = listener;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        
        try { 

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while ((clientGelen = in.readLine()) != null) {
            System.out.println("Client'dan gelen veri = " + clientGelen);
            sayi = Integer.valueOf(clientGelen);
            out.println(sayi * sayi);
        }
        out.close();
        in.close();
        clientSocket.close();
        listener.close();
        //Thread.sleep(60000);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
      
       

    }


}

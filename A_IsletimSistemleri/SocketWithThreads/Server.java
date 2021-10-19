/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_IsletimSistemleri.SocketWithThreads;

/**
 *
 * @author acar
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
public static void main(String[] args) throws IOException, ClassNotFoundException {
// don't need to specify a hostname, it will be the current machine
      ServerSocket ss = new ServerSocket(7777);
      try {
        while(true){
          
       
          System.out.println("ServerSocket awaiting connections...");
          Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
          Thread communicatingThread = new ServerCommunicatingThread(socket);
          communicatingThread.start();
        }
      } catch (Exception e) {
        ss.close();
      }
      
      
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_IsletimSistemleri.SocketWithThreads;
import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author acar
 */
public class ServerCommunicatingThread  extends Thread{
    
    
    private Socket socket;
           
    public ServerCommunicatingThread(Socket socket)
    {
        this.socket = socket;
    
    
    }
    @SuppressWarnings("unchecked")
    public void run(){
        
         System.out.println("Connection from " + socket + "!");
          // get the input stream from the connected socket
        InputStream inputStream=null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(ServerCommunicatingThread.class.getName()).log(Level.SEVERE, null, ex);
        }
// create a DataInputStream so we can read data from it.
        ObjectInputStream objectInputStream=null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(ServerCommunicatingThread.class.getName()).log(Level.SEVERE, null, ex);
        }
// read the list of messages from the socket
        List<Message> listOfMessages=null;
        
        try {
             listOfMessages =  (List<Message>) objectInputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ServerCommunicatingThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCommunicatingThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Received [" + listOfMessages.size() + "] messages from: " + socket);
// print out the text of every message
        System.out.println("All messages:");
        listOfMessages.forEach((msg)-> System.out.println(msg.getText()));
        System.out.println("Closing sockets.");
        
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerCommunicatingThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}

package EDS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.net.Socket;

public class P1 {
    public static void main(String[] args) throws IOException{
        

        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
       

        String serverAdress = "127.0.0.1";

        System.out.println("########### P1 nin Ekranı CLIENT GÖREVİNDE #############");


        Ogrenci ogrenci1 = new Ogrenci("2503", "Ayşe", "KARAKAŞ", "HUKUK" );

        
        
        try {
            socket = new Socket(serverAdress, 9091);                 //serverın dinlemekte olduğu 9091 nolu porta bağlanmayı çalışılır.
        } catch (Exception e) {
            System.out.println("porta bağlanma hatası:" + e);
            System.exit(34);
        }

        

        OutputStream outputStream = socket.getOutputStream();        //socket için outputStream oluşturur

        objectOutputStream = new ObjectOutputStream(outputStream);   //serialization işlemini yapacak nesne oluşturulur
        
        try {

            objectOutputStream.writeObject(ogrenci1);                //nesne serileştirilerek socket aracılığı ile P2 ye gönderilir
            System.out.println( "P2 ye gönderilen nesne:" + ogrenci1.toString() );

        } catch (Exception e) {

            System.out.println("ogrenci1 P2 ye gönderilirken hata:" + e);
            System.exit(35);
        }


        try {

            InputStream inputStream = socket.getInputStream();                                        // socketten gelecek verileri okumak için inputStream oluşturulur
            objectInputStream = new ObjectInputStream(inputStream);                                   // deserialization işlemini yapacak nesne oluşturulur 
            Ogrenci ogrenci3 = new Ogrenci(  (Ogrenci) objectInputStream.readObject()  ); // nesne deserialization işlemine uğrar.
            System.out.println( "P2 den alınan nesne   :" + ogrenci3.toString() );                    

        } catch (Exception e) {

            System.out.println("Ali isimli ogrenci2 yi P2 den alırken hata:" + e);
            System.exit(36);
        }
        
        

        socket.close();
        objectOutputStream.close();
        objectInputStream.close();

        
  
    }
}

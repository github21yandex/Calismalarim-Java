package EDS;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P2 {
    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = null;
        Socket socket = null;

        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        Ogrenci ogrenci2 = null;

        System.out.println("########### P2 nin Ekranı SUNUCU GÖREVİNDE #############");

        try {
            serverSocket = new ServerSocket(9091);                                          //9091 portuna bağlanmak için serverSocket nesnesi oluşturarak bu porta bağlanır

        } catch (Exception e) {

            System.out.println("Port Hatası:" + e);
            System.exit(43);
        }
        

        socket = serverSocket.accept();                                                    // Bu noktada bir bağlantının gelmesi beklenir. P1 den bağlanma isteği gelmediği sürece alt satıra geçilmez.
        
        try {
            InputStream inputStream = socket.getInputStream();                             // Socket ten gelecek verileri okumak için inputStream nesnesi oluşturulur

            objectInputStream = new ObjectInputStream(inputStream);                        // inputStream nesnesindeki veriye deserialization işelemi yapacak nesne oluşturulur

            ogrenci2 = new Ogrenci(   (Ogrenci) objectInputStream.readObject()  );         // nesne deserialization işlemine uğrar. Sonrada yeni bir ogrenci
                                                                                           // nesnesi oluşturularak bu yeni oluşturulan nesneye deepcopy yapılır.

            System.out.println("P1 den alınan nesne  :" + ogrenci2.toString() );
            

        } catch (Exception e) {
            System.out.println("P2, P1'den veri alırken hata:" + e);
            System.exit(44);

        }

        ogrenci2.setOgrenciAd("Ali");                                                       // P1 den gelen nesnenin ismi Ali olarak değiştirilir

        OutputStream outputStream = socket.getOutputStream();                               // socket için outputStream oluşturulur

        objectOutputStream = new ObjectOutputStream(outputStream);                          // serialization işlemini yapacak nesne oluşturulur
        
        try {

            objectOutputStream.writeObject(ogrenci2);                                       //nesne serileştirilerek P1 e gönderilir
            System.out.println("P1 e gönderilen nesne:" + ogrenci2.toString());

        } catch (Exception e) {

            System.out.println("ogrenci2 yi P1 e gönderilken hata:" + e);
            System.exit(45);
        }

        socket.close();
        serverSocket.close();
        objectInputStream.close();
        objectInputStream.close();




    }
}

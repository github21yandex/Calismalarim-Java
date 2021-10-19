package A_IsletimSistemleri.ServerClientData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

public class H2P4server {
    public static void main(String[] args) throws IOException{

        Scanner input = new Scanner(System.in);

        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        
        BufferedReader in = null;
        PrintWriter out = null;
        

        //aşağıda oluşturulan serverSocket nesnesi sayesinde serverin veri alışverişi
        //yapabilmesi için belirtilen porta bağlanır. Eğer 7755 portu kullanımda ya da 
        //kapalı olması durumunda bu porta bağlanma hatası alınacak ve program
        //System.exit(33) ile sonlanacaktı. ServerSocket nesnesi sadece port u ayarlamak 
        //için kullanılmaktadır. Bu nesne üzerinden herhangi bir mesaj alınıp gönederilmemektedir.
        //Bu iş için kullanılacak nesne yukarıda oluşturulan Socket nesnesidir.
        //Aşağıda clientSocket = clientSocket.accept() komutu ile serverSocket nesnesinin ayarladığı port
        //ile veri alış verişinin yapılacağı clientSocket nesnesi ilişkilendirilmiş olur.
        //clientSocket nesnesinin method ları ile mesajlar alınıp verilir.

        //Örneğin println ile veri gönderilir.
        //ancak önce verinin tüm stream lerin superclass ı olan outputStream e dönüştürülmesi gerekir.
        //outputstream byte lardan oluşan ve String ya da object gibi stream leri temsil eden superclass tır.
        //elimizdeki veri socket ile gönderilmek için uygun bir output stream e dönüştürülmesi gerekir.
        //bu işlem clientSocket.getOutputStream() kullanılır. Bu işlem sonucunda Socket ile gönderilmek
        //için uygun hale getrilmiş character tabanlı bir output stream elde ederiz.
        //Elde edilen character tabanlı output stream in de byte lara çevrilmesi gerekir
        //Bunun içinde PrintWriter kullanılır. PrintWriter ile byte larda oluşan output stream elde edilir.
        //Aslında bu komut ile character leri byte lara ceviren ara bir OutputStreamWriter yaratılır.
        //en sonunda da out.println() ile veri gönderilir.

        //readLine ve benzeri method larla veriler alınabilir.
        //ancak önce byte halinde alınan bu verilerin anlamlı hale getirilmesi gerekir.
        //clientSocket.getInputStream() ile sokentten byte ları okuyabilmek için bir inputstream elde edilir.
        //elde edilen inputStream lerin okunabilir character paketlerine dönüştürülmesi gerekir.
        //Bunun için de new InputStreamReader(clientSocket.getInputStream()) kullanılır. sonucta byte lar
        //character lere dönüştürülmüş olur.
        //bu character tabanlı inputStream okunabilir metinlere çevrilmesi gerekir. Bunu için
        //in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //komutu kullanılarak inputStream ler okunabilir metine çevrilir.
        //bu okunabilir metinler de  in.readLine() komutu gibi komutlarla okunabilirler.

        
        try {
            // *Server 7755 portundan Client'ı dinliyor *//
            serverSocket = new ServerSocket(7755);

        } catch (Exception e) {

            System.out.println("PortHatası!:" + e);
            System.exit(33);
        }


        System.out.println("SERVER BAĞLANTI İÇİN HAZIR");

         // * Bağlantı sağlamadan program bir alt satırdaki kod parçasına geçmez yani (clientSocket = serverSocket.accept()) kodu çalışmaz
        // *//

        clientSocket = serverSocket.accept();
        
        System.out.println("Client baglanti kurdu\nClient a gondermek istediginiz cumleyi yazınız:\n");
        String cumle = input.nextLine();
        



        //Client'a veri gönderimi için kullandığımız PrintWriter nesnesi oluşturulur

        out = new PrintWriter(clientSocket.getOutputStream(), true);

        //oluşturulan out nesnesi aşağıdaki kod ile client nesnesine gönderilir.

        out.println(cumle);

        // yukarıdaki haliyle server sadece bir kez client ın bağlanmasını
        // bekler ve bir kez client a veri gönderir. Bunu sürekli
        // yapabilmek için kod bir while yapısına sokulmalıdır

        
        while(clientSocket.isConnected()){
            
            System.out.println("Client a gondermek istediginiz cumleyi yazınız:");
            cumle = input.nextLine();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            out.println(cumle);

            

            try {

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                System.out.println( in.readLine() );

            } catch (Exception e) {

                System.out.println("client bağlantı hatası:" + e);
            }
            

        }

        System.out.println("Client ile bağlantı kesildi ");


        out.close();
        clientSocket.close();
        serverSocket.close();
        input.close();

    }
}

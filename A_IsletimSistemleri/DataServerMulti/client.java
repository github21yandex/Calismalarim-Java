package A_IsletimSistemleri.DataServerMulti;

import java.io.*;
import java.net.*;

public class client implements Runnable {

	int id;

	public client(int id) {
		this.id = id;
	}

	@Override
	public void run() {

		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {

			// * server 'a localhost ve 7755 portu üzerinden başlantı sağlanıyor *//
			socket = new Socket("localhost", 7755);

		} catch (Exception e) {
			System.out.println("Port Hatası!");
		}

		try {
			// Server'a veri gönderimi için kullandığımız PrintWriter nesnesi oluşturduk
			out = new PrintWriter(socket.getOutputStream(), true);

			// * Server'dan gelen verileri tutan BufferedReader nesnesi oluşturulur *//
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {

			while (true) {

				// * Gönderilecek sayının girişi yapılıyor *//
				int b = (int) (Math.random() * 100);

				System.out.println("client_"+ id + " Server'a gönderilen Sayi:" + b);

				out.println(Integer.toString(b));

				System.out.println("client_" + id +" Server'dan gelen sonuç = " + in.readLine());

			}
		} catch (Exception e) {
			out.close();
			try {
				in.close();
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}

	}
}

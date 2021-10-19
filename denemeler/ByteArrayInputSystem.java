package denemeler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputSystem {

   public static void main(String[] args) throws IOException {

      String str = "Hello world !";

      byte[] content = str.getBytes(); // str deki tüm karakterler byte lara dönüştürüldü

      // for (int i = 0; i < content.length; i++) {
      // System.out.printf("%3d ", content[i]);
      // }
      // System.out.println();
      // for (int i = 0; i < content.length; i++) {
      // System.out.printf("%3c ", content[i]);
      // }

      InputStream inputStream = null;

      //Byte[] b = new Byte[content.length];

      inputStream = new ByteArrayInputStream(content);
      System.out.println(inputStream.read());

   }
}
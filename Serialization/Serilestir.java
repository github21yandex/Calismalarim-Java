package Serialization;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Serilestir {
   private ObjectOutputStream objectOutputStream;

   public void kaydet(Object obj){

      try {
         objectOutputStream = new ObjectOutputStream(new FileOutputStream("java.dat"));
      } catch (Exception e) {
         System.err.println("Dosya Açılamadı, Hata!");
      }

      try {
         objectOutputStream.writeObject(obj);
      } catch (IOException e) {
         
         e.printStackTrace();
      }
   }
}
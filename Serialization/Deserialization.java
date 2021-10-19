package Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Deserialization {

   private ObjectInputStream input;

   public Object oku() {
      try {
         input = new ObjectInputStream(new FileInputStream("java.dat"));

      } catch (Exception iOException) {
         System.err.println("Dosya açılamadı, Hata!");
      }

      try {
         JavaBlogSerializable blog = (JavaBlogSerializable) input.readObject();
         System.out.println(blog);
         return blog;
         
      } catch (ClassNotFoundException | IOException e) {
         
         e.printStackTrace();
      }

      return null;

   }
}
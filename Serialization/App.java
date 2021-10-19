package Serialization;

public class App {

   public static void main(String[] args){

      JavaBlogSerializable blog = new JavaBlogSerializable(59, "ağaçlar ve insanlar", 2000);

      Serilestir serilestir = new Serilestir();
      Deserialization deserilestir = new Deserialization();

      serilestir.kaydet(blog);

      JavaBlogSerializable yeniBlog = new JavaBlogSerializable();

      yeniBlog = (JavaBlogSerializable) deserilestir.oku();
      
      System.out.println(yeniBlog);
      


   }
   
}
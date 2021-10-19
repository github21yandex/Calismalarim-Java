package Serialization;

import java.io.Serializable;


public class JavaBlogSerializable implements Serializable{
   /**
	 *
	 */
   private static final long serialVersionUID = 1L;
   
   public int toplamYazi;
   public String yaziKonusu;
   public int blogHit;

   JavaBlogSerializable(int toplamYazi, String yaziKonusu, int blogHit){
      this.toplamYazi = toplamYazi;
      this.yaziKonusu = yaziKonusu;
      this.blogHit = blogHit;
   }

   JavaBlogSerializable(){

   }

   @Override
   public String toString() {
      return "JavaBlogSerializable [blogHit=" + blogHit + ", toplamYazi=" + toplamYazi + ", yaziKonusu=" + yaziKonusu
            + "]";
   }

   

}
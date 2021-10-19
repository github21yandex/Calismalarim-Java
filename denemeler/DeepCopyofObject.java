package denemeler;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;


public class DeepCopyofObject {
   public static void main(String[] args){

      Insan [] insanlar = new Insan [50];
      
      for (int i = 0; i < 50; i++) {
         insanlar[i] = new Insan(  Integer.toString(i+100), i, Integer.toString(i+11100)   );
      }

      System.out.println("insanlar[0]= " + insanlar[0]);
      modify(insanlar);
      System.out.println("insanlar[0]= " + insanlar[0]);

      

   }

   public static void modify(Insan [] insanlar){

      Insan [] temp = new Insan[insanlar.length];

      // aşağıdaki sadece shallow copy yapar
      //temp = insanlar;

      //aşağıdaki de sadece shallow copy yapar
      // for (int i = 0; i < insanlar.length; i++) {
      //    temp[i] = insanlar[i];
      // }

      // aşağıdaki de sadece shallow copy yapar
      // for (int i = 0; i < insanlar.length; i++) {
      //    temp[i] = new Insan();
      //    temp[i] = insanlar[i];
      // }


      //aşağıdaki deep copy yapar
      // for (int i = 0; i < insanlar.length; i++) {
      //    temp[i] = new Insan(insanlar[i]);
      // }

      //aşağıdaki de deep copy yapar
      // for (int i = 0; i < insanlar.length; i++) {
      //    temp[i] = new Insan();

      //    temp[i].setIsim(insanlar[i].getIsim());
      //    temp[i].setYas(insanlar[i].getYas());
      //    temp[i].setTel(insanlar[i].getTel());
      // }

      //JavaDeepCloneBySerialization
      for (int i = 0; i < insanlar.length; i++) {
         temp[i] = deepClone(insanlar[i]);
      }

      System.out.println("temp[0]    = " + temp[0]);
      temp[0].setIsim("bbbbbb");
      System.out.println("temp[0]    = " + temp[0]);

   }

   public static <T extends Object> T deepClone(T object) {
      try {
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(object);
         ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
         ObjectInputStream ois = new ObjectInputStream(bais);
         @SuppressWarnings("unchecked") T result = (T)ois.readObject();

         return result;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
      
   }

  
}



class Insan implements Serializable{
   /**
    *
    */
   private static final long serialVersionUID = 1L;
   String isim;
   int yas;
   String tel;

   Insan(String isim, int yas, String tel){
      this.isim = isim;
      this.yas = yas;
      this.tel = tel;
   }

   Insan(){
   }

   Insan(Insan obj){
      this.isim = obj.getIsim();
      this.yas = obj.getYas();
      this.tel = obj.getTel();
   }

   @Override
   public String toString(){
      return String.format("%8s %8s %8s", isim, yas, tel);
   }

   public String getIsim() {
      return isim;
   }

   public void setIsim(String isim) {
      this.isim = isim;
   }

   public int getYas() {
      return yas;
   }

   public void setYas(int yas) {
      this.yas = yas;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }
}
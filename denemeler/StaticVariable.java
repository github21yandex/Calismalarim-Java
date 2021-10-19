package denemeler;

public class StaticVariable {
   public static void main(String[] args) {
      
      Kedi kedi1 = new Kedi(22);
      Kedi kedi2 = new Kedi(25);
      System.out.println(kedi1);
      System.out.println(kedi2);
      kedi1.setYas(23);
      

   }
   
}


class Kedi{

   public static int yas;

   Kedi(int yas){
      Kedi.yas = yas;
   }

   public int getYas() {
      return yas;
   }

   public void setYas(int yas) {
      Kedi.yas = yas;
   }

   @Override
   public String toString() {
      return "Kedi [yas=" + yas + "]";
   }

  
   
}
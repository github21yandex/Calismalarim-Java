package BigDecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.Locale;

public class App {
   public static void main(String[] args) {

      Locale locale = new Locale("tr", "TR");

      Insan insan = new Insan("ali", 12);

      Insan.birlestir();

      System.out.println(insan);

      Insan.getName();

      BigDecimal principal = BigDecimal.valueOf(3*Math.pow(10, 101) );
      BigDecimal rare = BigDecimal.valueOf(333);
      BigDecimal sum;

      

      System.out.println(principal + " - " + rare);

      principal = BigDecimal.valueOf(4444);

      BigDecimal.valueOf(1212);

      sum = rare.multiply(BigDecimal.valueOf(10));

      sum = sum.add(BigDecimal.ONE);
      
      sum = sum.add(BigDecimal.TEN, MathContext.UNLIMITED);

      sum = sum.pow(4);

      System.out.println(principal + " - " + rare );
      System.out.println( "sum = " + NumberFormat.getCurrencyInstance(locale).format(sum));


   }
}

class Insan{
   public static String name;
   int yas;

   Insan (String name, int yas){
      Insan.name = name;
      this.yas = yas;
   }

   public static void birlestir(){
      int yil = 2020;
      System.out.println(yil);
      
      Insan.name=Insan.name+Insan.name;
   }

   @Override
   public String toString() {
      return "Insan [yas=" + yas + "]";
   }

   public static String getName() {
      return name;
   }

   public static void setName(String name) {
      Insan.name = name;
   }

   public int getYas() {
      return yas;
   }

   public void setYas(int yas) {
      this.yas = yas;
   }
   
   
}

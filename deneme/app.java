package deneme;

import java.util.InputMismatchException;
import java.util.Scanner;

public class app {


   public static int quotient( int numerator, int denominator)
   //throws ArithmeticException
   {
    return numerator / denominator;  
   }

   public static void main(String[] args) {
      int f = -11;
      f = f%2;
      System.out.println("f = " + f);
     

      boolean continueLoop = true;

      do{
         try{
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            int b = input.nextInt();
            int result = quotient(a, b);
            System.out.println("sonuç =" + result );
            continueLoop = false;
            input.close();

         }
         catch(InputMismatchException inputMismatchException){
            System.err.printf("integer gir!");
         }
         catch(ArithmeticException aritmeticException){
            System.err.printf("aritmeticException");
         }
      }
      while(continueLoop);
     
      
      
   }
}

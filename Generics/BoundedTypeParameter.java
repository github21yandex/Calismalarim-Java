package Generics;

public class BoundedTypeParameter {

    public static <  T extends Comparable<T>  >    T    Maximum(T T1, T T2, T T3) {
       
        T max = T1;
        
        if(T2.compareTo(max) > 0) {
            max = T2;   // y is the largest so far
         }
         
         if(T3.compareTo(max) > 0) {
            max = T3;   // z is the largest now                 
         }
        
  

    return max;

    }

    public static void main(String[] args) {
        int T1 = 5;
        int T2 = 7;
        int T3 = 9;

       System.out.println("sayilar=" + T1 +"  "+ T2 + "  "+ T3);
       System.out.println("maximum=" + Maximum(T1, T2, T3));

    }
}

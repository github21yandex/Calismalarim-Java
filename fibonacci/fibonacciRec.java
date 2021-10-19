package fibonacci;

import java.util.Scanner;

public class fibonacciRec {


    public static int fibonacci(int i){
        if( i == 1 || i == 0){

            return i;
        }
        else{
    
            return ( fibonacci(i-1)+fibonacci(i-2) );
        }
    }
        public static void main(String[] args) {
            Scanner a = new Scanner(System.in);
            System.out.print("bir sayi giriniz:");
            int sayi = a.nextInt();

            long time1 = 0;
            long time2 = 0;
            
            time1 = System.nanoTime();
            long sonuc = fibonacci(sayi);
            time2 = System.nanoTime();
        System.out.printf("fibonacci(%d) = %d\n", sayi, sonuc);
        
        System.out.printf("hesapSüresi = %f Seconds\n", (float)(time2-time1)/1000000000);
        System.out.printf("hesapSüresi = %d milliSeconds\n", (time2-time1)/1000000);
        System.out.printf("hesapSüresi = %d microSeconds\n", (time2-time1)/1000);
            
        a.close();
    }
}
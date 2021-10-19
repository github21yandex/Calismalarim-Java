package FibonacciDynamicPro;

public class FibonacciDynamicPro {
   public static void main(String[] args){
      long time1 = 0;
		long time2 = 0;
		
      long n =100;

      long [] fibList = new  long [ (int)n + 1 ];

      time1 = System.nanoTime();
      long sonuc = fib(n, fibList);
      time2 = System.nanoTime();
      System.out.printf("fib(%d)     = %d\n", n, sonuc);
      System.out.printf("hesapSüresi = %f Seconds\n", (float)(time2-time1)/1000000000);
      System.out.printf("hesapSüresi = %d milliSeconds\n", (time2-time1)/1000000);
      System.out.printf("hesapSüresi = %d microSeconds\n", (time2-time1)/1000);
   }

   public static long fib(long n, long [] fibList){

      if( n== 0 || n == 1)
         return n;
      else if ( fibList[(int)n] != 0){
         System.out.printf("fibList[%d] = %d\n", n, fibList[(int)n]);
         return fibList[(int)n];
      }
      else{

         return fibList[( int) n ] =  fib(n-1, fibList) + fib(n-2, fibList);
         
      }
   }
}
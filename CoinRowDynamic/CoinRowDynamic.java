package CoinRowDynamic;

public class CoinRowDynamic {
    

   public static void main(String[] args){
      int [] CoinRow = {0, 5, 1, 2, 10, 6, 2};
      int [] F = new int [CoinRow.length];
      
      F[0] = 0;
      F[1] = CoinRow[1];
      maxCoin(CoinRow, F);
      System.out.println(F[F.length-1]);

      

   }

   public static double maxCoin(int [] CoinRow, int [] F){

      for (int i = 2; i < F.length; i++) {
         F[i] = Math.max( CoinRow[i] + F[i-2], F[i-1]);
         System.out.printf("F[%d] = %d\n",i,F[i]);  
      }

      return F[F.length-1];

   }
      
   
}

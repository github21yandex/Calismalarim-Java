package AlgFinal;

public class RobotCoinCollection {
    
    
   public static double maxValue(int [][] plane){
      
      int row = plane.length;
      int column = plane[0].length;

      int [][] func = new int [row][column];

      func[0][0] = plane[0][0];

      for (int i = 1; i < row; i++) {

         func[0][i] = plane[0][i] + func[0][i-1];
      }

      for (int i = 1; i < row; i++) {

         func[i][0] = plane[i][0] + func[i-1][0];

         for (int j = 1; j < column; j++) {

            func[i][j] = Math.max(func[i][j-1], func[i-1][j]) + plane[i][j];
         }

      }

      return func[row-1][column-1];

   }


   // public static double maxValueBruteForce(int [][] plane){
      
   //    int row = plane.length;
   //    int column = plane[0].length;

      

   //    double toplam = plane[0][0];



          
   //    boolean [] dizi = new boolean [row*column];
      
  
   //    for (int i = 0; i <= row*column + 2 ; i++) {
   //       for (char a : Integer.toBinaryString(i).toCharArray()) {
            
   //       }
   //    }
      

   //    return toplam;

   // }



   
   
}

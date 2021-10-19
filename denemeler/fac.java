package denemeler;

public class fac{

    public  static int factorial(int n){
        
        if ( n <= 0){
            return 1;
        }
        
        int carpim = 1;
        
        for (int i = n; i > 0; i-- ){
            carpim *= i;
        }
        
        return carpim;
        
    }
    public static void main(String[] args){

        int termCount = 9;
        double apprE = 0;
        double facTermCount = factorial(termCount);
        System.out.printf("%f\n", facTermCount);

        for (int i = termCount; i > 0; i--){
            facTermCount /= i;
            apprE += 1/facTermCount;
        }

        System.out.printf("%.20f\n", apprE);
    }

}
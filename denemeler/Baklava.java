package denemeler;
import java.util.Scanner;

public class Baklava {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Satir sayisini giriniz:");
        int number = input.nextInt();

        int r = number/2;
             
        for(int i = r; i >= -r ; i--){

            int k = (int) Math.sqrt(i*i);

            for(int j = k; j > 0; j--){
                System.out.print(" ");                
            }
            System.out.print("*");

            double temp = 2*(r-k)-1;
            for(int j = (int) temp; j > 0; j--){
                System.out.print(" ");
            }
            if ( temp > 0){
                System.out.print("*\n");
            }
            else{
                System.out.print("\n");
            }

          


            
        }

        input.close();

    }
}
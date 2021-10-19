package piNumber;
public class PiSayisi{

    public static void main(String[] args){

        double x, y;

        double daire = 0;
        double kare= 0;

        for (int i = 0; i <= 100000; i++) {

            x = Math.random();
            y = Math.random();
            
            kare ++;

            if (Math.sqrt(x*x + y*y) <= 1 ){
                daire ++;
                
            }
                
            
        }


        System.out.printf("pi = %f", 4*daire/kare);

    }
}
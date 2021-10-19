package integral;

public class Integral{

    public static double denklem(double x){

        return x*x;

    }

    public static double integral(double a, double b, double h){

        double toplam = 0;

        double alan;

        for (double i = a; i <= b; i+=h) {
            
            alan = denklem(i+h/2)*h;
            
            if (alan < 0)
                toplam -= alan;

            else
                toplam += alan;
            
        }
        return toplam;

    }

    public static void main(String[] args){

    System.out.printf("%.2f", integral(-9, 5, 0.1) );



    }
}



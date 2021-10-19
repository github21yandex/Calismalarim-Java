package hesaplamalar;

public class Hesaplamalar{

    private static double Pi = 3.14;

    //private static double e  = 2.7182;


    public static double pisagor(double X, double Y){

        return Math.sqrt( X*X + Y*Y);
    }

    public static double daireAlan(double r){
        
        return Pi*r*r;
    }
    
    public static double daireCevre(double r){
        Pi = 3;
        return 2*Pi*r;
    }

    public static double kureHacim(double r){
        return 4/3*Pi*r*r*r;
    }

}
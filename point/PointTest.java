package point;

//import java.util.Scanner;

public class PointTest{
    public static void main(String[] args){
        //Scanner input = new Scanner(System.in);
        

        Point point1 = new Point(5, 7 );

        System.out.println("point1 (X,Y)= " + point1.getX() + point1.getY() );

        System.out.println(point1.toString());
        
    }
    

    public float distance(Point point1, Point point2) {


        float distance = 0;
        int d1 = point1.getX()-point2.getX();
        int d2 = point1.getY()-point2.getY();
        distance = (float) Math.sqrt(Math.pow(d1, 2) + Math.pow(d2, 2));

        return distance;
    }
}
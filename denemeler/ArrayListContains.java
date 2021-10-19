package denemeler;
import AlgAraSinav.Point;
//import java.util.Comparator;
//import java.util.Arrays;

import java.util.ArrayList;

public class ArrayListContains {

   public static void main(String[] args){


      ArrayList<Point> bunlar = new ArrayList<Point>();
      ArrayList<Point> onlar = new ArrayList<Point>();

      
      Point [] array = new Point [5];
      array[0] = new Point(1,2);
      array[1] = new Point(3,6);
      array[2] = new Point(5,6);
      array[3] = new Point(7,8);
      array[4] = new Point(9,0);
       

      for (int i = 0; i < 10; i++) {

         bunlar.add(new Point(i, 2*i));
      }
      Point a = new Point(3,6);
      //bunlar.add(a);

      Point b = bunlar.get(3);

      

      onlar.add(a);

      System.out.println(bunlar);
      System.out.println(onlar);

      System.out.println(incld(a, bunlar));

      System.out.println(    bunlar.contains(  onlar.get(0)  )    );

      System.out.println(  bunlar.contains(array[1])  );

      System.out.println(  bunlar.contains(a)  );

      System.out.println(  bunlar.contains(b) +"---" + b );

      System.out.println(a.getClass());

      System.out.println(  "--------------------------------" );

      
      ArrayList<Point> eski = new ArrayList<Point>();

      
      for (int i = 0; i < 10; i++) {
         eski.add(new Point(i,i*2));
      }

      ArrayList<Point> yeni = new ArrayList<Point>(eski);
      
      for (Point point : yeni) {
         System.out.println(point);
      }
      


      
      

      
  



   }

   public static int incld(Point x, ArrayList<Point>list){
      for (Point point : list) {
         if(   point.getX() == x.getX() && point.getY() == x.getY()   ){
            return list.indexOf(point);
         }         
      }
      return -1;
         
   }
     
         
   
   
}
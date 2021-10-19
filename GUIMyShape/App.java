package GUIMyShape;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import java.awt.Color;

import java.security.SecureRandom;

public class App {
   
   enum shape {MyRectangle, MyCircle};

   public static void main(String[] args) {

      SecureRandom random = new SecureRandom();

      MyShape [] shapes = new  MyShape [2] ;
      shapes[0] = new MyRectangle();
      shapes[1] = new MyCircle();

       
      JFrame frame = new JFrame();
      
      frame.setSize(600, 600);
      
      // DrawRectangle drawRectangle = new DrawRectangle(20, 30, 100, 150, Color.RED);

      // DrawCircle drawCircle = new DrawCircle(25, 50, 200, 175, Color.BLUE);
      
      MyShape [] myShapes = new MyShape[20];

      for (int i = 0; i < myShapes.length; i++) {
         myShapes[i] = shapes[random.nextInt(shapes.length)].shapeCreate(random.nextInt(300), random.nextInt(300), random.nextInt(300), random.nextInt(300), new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
         
      }

      DrawShape drawShape = new DrawShape(myShapes);
      frame.add(drawShape);
   
      
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.setVisible(true);

   
   }
   
   
}
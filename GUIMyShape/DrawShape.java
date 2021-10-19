package GUIMyShape;

import javax.swing.JPanel;
import java.awt.Graphics;


public class DrawShape extends JPanel{
   
   MyShape [] myShapes;

   private static final long serialVersionUID = 1L;

   DrawShape(MyShape [] myShapes){
      this.myShapes = myShapes;
   }

   

   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      for (MyShape myShape : myShapes) {

         myShape.draw(g);

      }
      

   }


   
}
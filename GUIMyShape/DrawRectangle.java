package GUIMyShape;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

public class DrawRectangle extends JPanel {

   private static final long serialVersionUID = 1L;

   MyRectangle myRectangle;
   
   public DrawRectangle(int x, int y, int width, int height, Color color){

      this.myRectangle = new MyRectangle(x, y, width, height, color);
   
   }

   public void drawRectangle(MyRectangle myRectangle){

      this.myRectangle = myRectangle;
   
   }



   public void paintComponent(Graphics g){

      super.paintComponent(g);

      
      this.myRectangle.draw(g);

   }
   


}
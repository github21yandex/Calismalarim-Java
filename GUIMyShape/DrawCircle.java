package GUIMyShape;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCircle extends JPanel{

   int x;
   int y;
   int width;
   int height;
   Color color;


   private static final long serialVersionUID = 1L;
   
   public DrawCircle(int x, int y, int width, int height, Color color) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.color = color;
     

   }



   public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(this.color);
      g.drawOval(x, y, width, height);

   }

   



}
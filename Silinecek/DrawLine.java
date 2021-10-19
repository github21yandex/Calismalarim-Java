package Silinecek;

import javax.swing.JPanel;
import java.security.SecureRandom;
import java.awt.Color;
import java.awt.Graphics;


public class DrawLine extends JPanel{


   private static final long serialVersionUID = 1L;

   private Line[] lines;

   private SecureRandom random = new SecureRandom();

   public DrawLine(int count, int size){
      
      lines = new Line[count];

      for (int i = 0; i < lines.length; i++) {
         int x1 = random.nextInt(size);
         int y1 = random.nextInt(size);
         int x2 = random.nextInt(size);
         int y2 = random.nextInt(size);
         Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

         lines[i] = new Line(x1, y1, x2, y2, color);
      }

   }

   public void paintCompanent(Graphics g){

      super.paintComponent(g);

      for(Line line: lines){
         line.draw(g);
      }

   }



}
package ObjectGUI;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.security.SecureRandom;

public class DrawPanel extends JPanel{

 
   private static final long serialVersionUID = 1L;

   private SecureRandom random = new SecureRandom();

   private MyLine [] myLines;

   public DrawPanel(){
      
      setBackground(Color.WHITE);

      myLines = new MyLine[10000];

      for( int i = 0; i < myLines.length; i++){

         int x1 = random.nextInt(300);
         int x2 = random.nextInt(300);
         int y1 = random.nextInt(300);
         int y2 = random.nextInt(300);

         Color color = new Color( random.nextInt(256), random.nextInt(256), random.nextInt(256)  );
         
         myLines[i] =new MyLine(x1, y1, x2, y2, color);
      }

   
   }


   public void paintComponent(Graphics g){

      super.paintComponent(g);

      for( MyLine myLine : myLines){
         myLine.draw(g);
      }

   }
   


}
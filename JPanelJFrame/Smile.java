package JPanelJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


public class Smile extends JPanel{

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int width = getWidth();
      int height = getHeight();

      g.setColor(Color.YELLOW);
      g.fillOval(0, 0, width, height);

      g.setColor(Color.BLACK);
      g.fillOval(width/5, height/5, width/5, height/5);
      g.fillOval(width*3/5, height/5, width/5, height/5);

      g.fillOval(width/5, height*3/5, width*3/5, height/5);

      g.setColor(Color.YELLOW);
      g.fillRect(width/5, (int)((double)height*2.9/5), width*3/5, height/8);
      g.fillOval(width/5, (int)((double)height*3.2/5), width*3/5, height/8);
   }

   static class app3 {
      public static void main(String[] args) {

         Smile smilePanel = new Smile();

         JFrame frame = new JFrame();

         frame.setSize(700, 700);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.add(smilePanel);
         frame.setVisible(true);
         
      }
   }
   
}
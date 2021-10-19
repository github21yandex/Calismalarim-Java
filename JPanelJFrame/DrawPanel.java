package JPanelJFrame;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;

class app{
   public static void main(String[] args){

      JFrame jFrameApp = new JFrame();

      DrawPanel panel = new DrawPanel();

      //jFrameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jFrameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      jFrameApp.setSize(300, 300);

      jFrameApp.add(panel);

      jFrameApp.setVisible(true);



   }
}


public class DrawPanel extends JPanel {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int height = getHeight()-20;
      int width = getWidth()-20;

      // for(int i = 1; i < 15; i++){
      //    g.drawLine(0+20,0+20, width - width/15*i, height/15*i);
      //    g.drawLine(width,0+20, width/15*i, height/15*i );
      //    g.drawLine(0+20,height, width/15*i, height/15*i );
      //    g.drawLine(width,height, width - width/15*i, height/15*i );
      // }

      for(int i = 1; i < 16; i++){
         int y = height/16*i;
         int x = width/16*i;
         
         

         g.drawLine(0, y, width-x, 0);
         g.drawLine(x, 0, width, y);
         g.drawLine(0, height-y, width - x, height);
         g.drawLine(x, height, width, height-y);
         
         
      }


      
   }
}
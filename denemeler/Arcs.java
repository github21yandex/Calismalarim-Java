package denemeler;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;


public class Arcs {

   public static void main(String[] args) {

      //Color red = new Color(10,10,10);

      JFrame frame = new JFrame();
      frame.setSize(400, 400);

      // DrawPanel panel = new DrawPanel();
      // DrawPanel2 panel2 = new DrawPanel2();
      DrawPanel3 panel3 = new DrawPanel3();

      
      frame.setBackground(Color.WHITE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(panel3);
      frame.setVisible(true);
      
   }
   
}




class DrawPanel extends JPanel{

   private static final long serialVersionUID = 1L;

   private final static Color VIOLET = new Color(128, 0, 128);
   private final static Color INDIGO = new Color(75, 0, 130);

   private Color [] colors = {VIOLET, INDIGO, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.WHITE};

   public DrawPanel(){
      setBackground(Color.WHITE);
   }

   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int radius = 20;
      
       for (int i = 0; i < colors.length; i++) {
          g.setColor(colors[i]);
          //g.fillArc(0, 0, getWidth(), getHeight()*2, 0, 180);
          g.fillArc(radius*i, i*20, getWidth()-i*40, 2*getHeight()-i*40, 0, 180);
       }

      
   }
}

class DrawPanel2 extends JPanel{

   private static final long serialVersionUID = 1L;

    

   public void paintComponent(Graphics g){
      super.paintComponent(g);

      int x = getWidth();
      int y = getHeight();

      for (int i = 1; i < 10; i++) {
         
         g.drawLine(x-i*20, y-i*20+20, x-i*20, i*20);
         g.drawLine(x-i*20, i*20, i*20, i*20);
         g.drawLine(i*20, i*20, i*20, y-i*20);
         g.drawLine(i*20, y-i*20, x-i*20-20, y-i*20);
      }
   }
}

class DrawPanel3 extends JPanel{

   private static final long serialVersionUID = 1L;

    

   public void paintComponent(Graphics g){
      super.paintComponent(g);

      int x = getWidth();
      int y = getHeight();
      

      for (int i = 1; i < 10; i++) {
         
         g.drawArc(20*i, i*20, x-40*i, y-40*i, 0, 180);
         g.drawArc(20*i, i*20, x-40*i-20, y-40*i, 180, 180);
      }
   }
}





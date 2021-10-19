package JPanelJFrame;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Shapes extends JPanel {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   private int choice;
   private int total;

   public Shapes(int choice, int total){
      this.choice = choice;
      this.total = total;
   }

   public void paintComponent(Graphics g){

      super.paintComponent(g);

      // int height = getHeight();
      // int width = getWidth();

      for( int i = 1; i <= total; i++){
         
         switch(choice){
            case 1:
               g.drawRect(i*10, i*10, 50+i*10,50+i*10);
               break;
            case 2:
               g.drawOval(i*10, i*10, i*10+50, i*10+50);
               break;
         }
      }

   }

}

class app2{
   public static void main(String[] args){
      

      String input = JOptionPane.showInputDialog(  "Enter 1 to draw rectengules\n"+
                                                   "      2 to draw Ovals");

      int choice = Integer.parseInt(input);

      String input2 = JOptionPane.showInputDialog(String.format("Enter a number for piece of %s", input));

      int total = Integer.parseInt(input2);

      Shapes panel = new Shapes(choice, total);

      JFrame frame = new JFrame();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.add(panel);

      frame.setSize(300, 300);

      frame.setVisible(true);




   }
}
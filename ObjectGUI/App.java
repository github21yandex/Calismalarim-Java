package ObjectGUI;

import javax.swing.JFrame;

public class App {

   public static void main(String[] args) {

   JFrame jframe = new JFrame();

   DrawPanel panel = new DrawPanel();

   jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   jframe.setSize(300, 300);

   jframe.add(panel);

   jframe.setVisible(true);
   }

   

   
}
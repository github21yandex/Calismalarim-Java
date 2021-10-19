package GUIMyShape;

import java.awt.Graphics;
import java.awt.Color;

public class MyCircle extends MyShape {
   
   public MyCircle(int x, int y, int width, int height, Color color) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.color = color;
   }
   public MyCircle() {
      
   }

   public MyCircle(MyCircle myCircle) {
      this.x = myCircle.x;
      this.y = myCircle.y;
      this.width = myCircle.width;
      this.height = myCircle.height;
      this.color = myCircle.color;
   }

   @Override
   public void draw(Graphics g){
      g.setColor(this.color);
      g.drawOval(x, y, width, height);
   }

   @Override
   public MyShape shapeCreate(int x, int y, int width, int height, Color color) {
      MyCircle temp = new MyCircle(x, y, width, height, color);
      return temp;
   }


}
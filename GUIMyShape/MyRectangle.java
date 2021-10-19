package GUIMyShape;
import java.awt.Graphics;
import java.awt.Color;


public class MyRectangle extends MyShape {

   

   public MyRectangle(int x, int y, int width, int height, Color color) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.color = color;
   }

   public MyRectangle(MyRectangle myRectangle) {
      this.x = myRectangle.x;
      this.y = myRectangle.y;
      this.width = myRectangle.width;
      this.height = myRectangle.height;
      this.color = myRectangle.color;
   }

   public MyRectangle() {
      
   }


   @Override
   public void draw(Graphics g){ 
      g.setColor(this.color);
      g.drawLine(x, y, x+width, y);
      g.drawLine(x+width, y, x+width, y+height);
      g.drawLine(x+width, y+height, x, y+height);
      g.drawLine(x, y+height, x, y);
   }

   @Override
   public MyShape shapeCreate(int x, int y, int width, int height, Color color) {
      MyRectangle temp = new MyRectangle(x, y, width, height, color);
      return temp;
   }
   
}
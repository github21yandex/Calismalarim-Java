package GUIMyShape;
import java.awt.Color;


public abstract class MyShape implements ShapeInterface {

   Color color;
   int x;
   int y;
   int width;
   int height;

   public MyShape() {

      this.color = Color.BLACK;
      this.x = 0;
      this.y = 0;
      this.width = 0;
      this.height = 0;
   }

   
}
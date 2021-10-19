package GUIMyShape;

import java.awt.Graphics;
import java.awt.Color;

public interface ShapeInterface {
   
   public abstract void draw(Graphics g);
   public abstract MyShape shapeCreate(int x, int y, int width, int height, Color color);

}
package GenericConstrutor;

import java.io.Serializable;

import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.ranges.Range;
import org.w3c.dom.ranges.RangeException;

public class Product implements Range, Serializable {
 
   private static final long serialVersionUID = 1L;
   private String name;
   private double price;
   private int sales;

   public Product(String name, double price) {
      this.name = name;
      this.price = price;
   }


   public int getRank() {
      return sales;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public int getSales() {
      return sales;
   }

   public void setSales(int sales) {
      this.sales = sales;
   }

   @Override
   public Node getStartContainer() throws DOMException {
      
      return null;
   }

   @Override
   public int getStartOffset() throws DOMException {
      
      return 0;
   }

   @Override
   public Node getEndContainer() throws DOMException {
      
      return null;
   }

   @Override
   public int getEndOffset() throws DOMException {
      
      return 0;
   }

   @Override
   public boolean getCollapsed() throws DOMException {
   
      return false;
   }

   @Override
   public Node getCommonAncestorContainer() throws DOMException {
      
      return null;
   }

   @Override
   public void setStart(Node refNode, int offset) throws RangeException, DOMException {
      

   }

   @Override
   public void setEnd(Node refNode, int offset) throws RangeException, DOMException {
   

   }

   @Override
   public void setStartBefore(Node refNode) throws RangeException, DOMException {
      

   }

   @Override
   public void setStartAfter(Node refNode) throws RangeException, DOMException {
      

   }

   @Override
   public void setEndBefore(Node refNode) throws RangeException, DOMException {
      

   }

   @Override
   public void setEndAfter(Node refNode) throws RangeException, DOMException {
      

   }

   @Override
   public void collapse(boolean toStart) throws DOMException {
      

   }

   @Override
   public void selectNode(Node refNode) throws RangeException, DOMException {
      

   }

   @Override
   public void selectNodeContents(Node refNode) throws RangeException, DOMException {
      

   }

   @Override
   public short compareBoundaryPoints(short how, Range sourceRange) throws DOMException {
      
      return 0;
   }

   @Override
   public void deleteContents() throws DOMException {
      

   }

   @Override
   public DocumentFragment extractContents() throws DOMException {
      
      return null;
   }

   @Override
   public DocumentFragment cloneContents() throws DOMException {
      
      return null;
   }

   @Override
   public void insertNode(Node newNode) throws DOMException, RangeException {
      

   }

   @Override
   public void surroundContents(Node newParent) throws DOMException, RangeException {
      

   }

   @Override
   public Range cloneRange() throws DOMException {
      
      return null;
   }

   @Override
   public void detach() throws DOMException {
      

   }
}
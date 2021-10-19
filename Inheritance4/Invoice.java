package Inheritance4;

public class Invoice implements Payable {
   private final String partNumber;
   private final String partDescription;
   private int quantity;
   private double priceItem;

   public Invoice (String partNumber, String partDescription, int quantity, double priceItem){
      this.partNumber = partNumber;
      this.partDescription = partDescription;
      this.quantity =  quantity;
      this.priceItem = priceItem;
   }

   public String getPartNumber() {
      return partNumber;
   }

   public String getPartDescription() {
      return partDescription;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public double getPriceItem() {
      return priceItem;
   }

   public void setPriceItem(double priceItem) {
      this.priceItem = priceItem;
   }

   @Override
   public String toString() {
      return "Invoice [partDescription=" + partDescription + ", partNumber=" + partNumber + ", priceItem=" + priceItem
            + ", quantity=" + quantity + "]";
   }

   @Override
   public double getPaymentAmount(){
      return quantity * priceItem;
   }

}
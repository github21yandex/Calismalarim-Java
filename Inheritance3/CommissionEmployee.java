package Inheritance3;

public class CommissionEmployee extends Employee {
  
   private double grossSales;
   private double commissionRate;

   public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate){
      
      super(firstName, lastName, socialSecurityNumber);
      
      if (grossSales < 0){
         throw new IllegalArgumentException(
            "Gros sales must be >= 0"
         );
      }
   
      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   }

   public double getGrossSales() {
      return grossSales;
   }

   public void setGrossSales(double grossSales) {
      this.grossSales = grossSales;
   }

   public double getCommissionRate() {
      return commissionRate;
   }

   public void setCommissionRate(double commissionRate) {
      this.commissionRate = commissionRate;
   }


   public double earnings(){
      return commissionRate*grossSales;
   }
   
   @Override
   public String toString() {
      return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
      "commissionEmployee", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
   }
}
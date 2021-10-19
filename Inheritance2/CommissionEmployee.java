package Inheritance2;

public class CommissionEmployee extends Object {
   protected final String firstName;
   protected final String lastName;
   protected final String socialSecurityNumber;
   protected double grossSales;
   protected double commissionRate;

   public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate){
      if (grossSales < 0){
         throw new IllegalArgumentException(
            "Gros sales must be >= 0"
         );
      }
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;
      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getSocialSecurityNumber() {
      return socialSecurityNumber;
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
      return "\ncommissionRate=" + commissionRate + "\nfirstName=" + firstName + "\ngrossSales="
            + grossSales + "\nlastName=" + lastName + "\nsocialSecurityNumber=" + socialSecurityNumber + "]";
   }
}
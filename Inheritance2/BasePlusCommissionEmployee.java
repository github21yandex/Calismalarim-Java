package Inheritance2;

public class BasePlusCommissionEmployee extends CommissionEmployee {

   private double baseSalary;

   public BasePlusCommissionEmployee(String firstName, String lastName,
      String socialSecurityNumber, double grossSales,
         double commissionRate, double baseSalary) {

      super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

      this.baseSalary = baseSalary;
   }

   public void setBaseSalary(double salary){
      baseSalary = salary;
   
   }
   public double getBaseSalary(){
      return baseSalary;
   }

   @Override
   public double earnings(){
      return baseSalary + commissionRate*grossSales;
   }

   @Override
   public String toString() {
      return "\ncommissionRate=" + commissionRate + "\nfirstName=" + firstName + "\ngrossSales="
            + grossSales + "\nlastName=" + lastName + "\nsocialSecurityNumber=" + socialSecurityNumber +
            "\nbaseSalary"+ baseSalary;
   }
   

}
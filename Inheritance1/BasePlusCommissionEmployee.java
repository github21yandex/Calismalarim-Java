package Inheritance1;

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
      return baseSalary + getCommissionRate()*getGrossSales();
   }

   @Override
   public String toString() {
      return "\ncommissionRate=" + getCommissionRate() + "\nfirstName=" + getFirstName() + "\ngrossSales="
            + getGrossSales() + "\nlastName=" + getLastName() + "\nsocialSecurityNumber=" + getSocialSecurityNumber() +
            "\nbaseSalary"+ baseSalary;
   }
   

}
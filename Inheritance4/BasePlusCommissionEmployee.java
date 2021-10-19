package Inheritance4;

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
      //*
      return baseSalary + super.earnings(); /**/
      /*
      return baseSalary +getCommissionRate()*getGrossSales(); /**/
      
      // yukarıdaki iki ifade de aynı şeyi ifade eder
   }

   @Override
   public double getPaymentAmount() {
      return earnings();
   }

   @Override
   public String toString() {
      return String.format("%s %s; %s: $%,.2f",
      "base-salaried", super.toString(), "base salary", getBaseSalary()  );
   }
   

}
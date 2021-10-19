package Inheritance4;

public class SalariedEmployee extends Employee{

   private double weeklySalary;

   public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary){
      super(firstName, lastName, socialSecurityNumber);
      this.weeklySalary = weeklySalary;
   }

   public void setWeeklySalary(double weeklySalary){
      this.weeklySalary = weeklySalary;
   }

   public double getWeeklySalary(){
      return weeklySalary;
   }
   
   @Override
   public double earnings(){
      return getWeeklySalary();
   }

   @Override
   public double getPaymentAmount(){
      return getWeeklySalary();
   }

   public String toString(){
      return String.format("SalariedEmployee:%s%n%s:$%,.2f",
      super.toString(),"weekly salary", getWeeklySalary());
   }
   
}
package Inheritance4;


public abstract class Employee implements Payable {

   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;

   public Employee(String firstName, String lastName, String socialSecurityNumber){
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;

   }

   public String getFirstName(){
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getSocialSecurityNumber() {
      return socialSecurityNumber;
   }
   
   
   public abstract double earnings();//

   @Override
   public String toString(){
      return String.format("%s %s%nsocial S. number:%s", getFirstName(),getLastName(),getSocialSecurityNumber());
   }

   //getPaymentAmount() methodu buraya implement edilmedi 

}
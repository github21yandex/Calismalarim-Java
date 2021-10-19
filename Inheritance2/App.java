package Inheritance2;


public class App {
   public static void main(String[] args){
      
      CommissionEmployee employee = new CommissionEmployee("ali", "altan","1111-1-11", 1000, .06);
      System.out.println(employee.toString());

      BasePlusCommissionEmployee baseEmployee = new BasePlusCommissionEmployee("ayse", "Kare", "222-2-2-2", 300, .03, 200);
      System.out.println(baseEmployee);


      System.out.println(employee.getClass());
      System.out.println(baseEmployee.getClass());

      System.out.println(employee instanceof CommissionEmployee);
      
      /*
      System.out.println(employee instanceof BasePlusCommissionEmployee);
      System.out.println(employee instanceof CommissionEmployee);
      System.out.println(baseEmployee instanceof BasePlusCommissionEmployee);
      System.out.println(baseEmployee instanceof CommissionEmployee);
      /**/
   }
   
}
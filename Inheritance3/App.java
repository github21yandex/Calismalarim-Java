package Inheritance3;


public class App {
   public static void main(String[] args){
      
      SalariedEmployee salariedEmployee = new SalariedEmployee("fatma", "ateş", "232-323-32", 200);
      System.out.println(salariedEmployee + "\n");

      HourlyEmployee hourlyEmployee = new HourlyEmployee("veli", "ayık", "232-2342-423", 20, 30);
      System.out.println(hourlyEmployee + "\n");

      CommissionEmployee commissionEmployee = new CommissionEmployee("ali", "altan","1111-1-11", 1000, .06);
      System.out.println(commissionEmployee.toString() + "\n");

      BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("ayse", "Kare", "222-2-2-2", 300, .03, 200);
      System.out.println(basePlusCommissionEmployee + "\n");
      //Employee abstract olduğundan aşağıdaki şekilde tanımlama yapılamaz
      //Employee employee7 = new Employee("ahmed", "kerim", "323-233-");

      Employee [] employees = new Employee[4];
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee;
      employees[3] = basePlusCommissionEmployee;

      for (Employee currentEmployee : employees) {

         System.out.println(currentEmployee);

         if ( currentEmployee instanceof BasePlusCommissionEmployee){
            BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
            employee.setBaseSalary(1.1*employee.getBaseSalary());
            System.out.printf("new base salary is with 10%% increase %,.2f%n",employee.getBaseSalary()  );
         }

         System.out.printf("earned $%,.2f%n%n",currentEmployee.earnings());

      }

      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee.getFirstName());
      }

      for (int i = 0; i < employees.length; i++) {
         System.out.printf("employee %d is a %s%n", i, employees[i].getClass().getSimpleName() );
      }



   }
   
}
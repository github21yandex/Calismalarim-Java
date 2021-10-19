package Inheritance4;


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


      System.out.println("\n\n\n\n--PayableObjects----------------------------");

      Payable[] payableObjects = new Payable[4];

      //Payable payable7 = new Payable(); OLMAZ

      payableObjects[0] = new Invoice("1111", "seat", 2, 20.2);
      payableObjects[1] = new Invoice("2222", "tire", 3, 15.25);
      payableObjects[2] = new SalariedEmployee("Kazım", "yeşil", "1111-2-2-2-", 20);
      payableObjects[3] = new BasePlusCommissionEmployee("ilknur", "çomak", "333-2323-32-", 1000, 0.2, 1000);
   
      for (Payable payable : payableObjects) {
         System.out.println(payable.toString() +
         "\nPaymentAmount:" + payable.getPaymentAmount() + "\n");
      }

      System.out.println(payableObjects[3].getClass());

      String a = payableObjects[2].getClass().getSimpleName();

      System.out.println(a);


   }


   
}
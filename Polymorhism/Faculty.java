package Polymorhism;

public class Faculty extends Person{
   String EmployeeID;

   Faculty(String name, String EmployeeID){
      super(name);
      this.EmployeeID = EmployeeID;
   }

   public String isAsleep(){
      return "Awake";
   }

   public String getEmployeeID() {
      return EmployeeID;
   }

   public void setEmployeeID(String employeeID) {
      EmployeeID = employeeID;
   }

   public void type(){
      System.out.println( "Faculty" );
   }

   @Override
   public String toString() {
      return "Faculty [name=" + name + " EmployeeID=" + EmployeeID + "]";
   }

   
   
}
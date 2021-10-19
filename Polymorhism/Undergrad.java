package Polymorhism;

public class Undergrad extends Student{
   public int date;

   Undergrad(String name, int studentID, int date){
      super(name, studentID);
      this.date = date;
   }

   // Undergrad(Student student, int date){
   //    super(name, studentID);

   //    this.date = date;
   // }

   public void trust(){
      System.out.println( "Undergrad trust" );
   }

   @Override
   public String toString() {
      return "Undergrad [name=" + name + " studentID=" + studentID + " date=" + date + "]";
   }

   
   
}
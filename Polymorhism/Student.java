package Polymorhism;

public class Student extends Person {
   public int studentID;

   Student(String name, int studentID){

      super(name);

      this.studentID = studentID;

   }

   public String isAsleep(){
      return "Asleep";
   }

   public void type(){
      
      System.out.println( "Student" );

      super.trust();
      trust();
   }

   public void trust(){
      System.out.println("Student trust");
   }



   public int getStudentID() {
      return studentID;
   }

   public void setStudentID(int studentID) {
      this.studentID = studentID;
   }
   

   @Override
   public String toString() {
      return "Student [name=" + name + " studentID=" + studentID + "]";
   }
}
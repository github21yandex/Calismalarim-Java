package Polymorhism;

public class Person {
   public String name;
   public boolean alive = true;

   Person(String name){
      this.name = name;
   }



   public String isAsleep(){
      return "Person is Faculty or Student?";
   }

   public void setdeath(){
      this.alive = false;
   }

   public boolean isAlive(){
      return alive;
   }

   public void type(){
      System.out.println( "Person" );
   }

   public void trust(){
      System.out.println( "Person trust " );
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "Person [name=" + name + "]";
   }

}
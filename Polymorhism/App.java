package Polymorhism;

public class App {
   public static void main(String[] args) {

      Person s1 = new Person("veli");
      Person s2 = new Student("ali", 123);
      System.out.println(s1 + "\n" + s2);

      System.out.println( s2 instanceof Person);


      Person p[] = new Person[5];

      p[0] = new Person("ayse");
      p[1] = new Student("hakan", 124);        //widening işlemi //int to double
      p[2] = new Faculty("melih", "ABCD");
      p[3] = new Undergrad("kazım", 444, 1992);
      //p[4] = new Undergrad((Student) p[1], 1995);

      // Aşağıdaki şekilde bir kullanım olamaz çünkü derleyici sadece sınıf ismine ait
      // metodlara bakar. Person da setStudentID() bulunmamaktadır.
      // p[1].setStudentID(444);

      ((Student) p[1]).setStudentID(333);      //casting//narrowing işlemi //double to int


      System.out.println("\n\n tüm p[] kişileri\n");
      for (Person person : p) {
         System.out.println(person);         
      }

      System.out.println("\n\n\n p[] kişileri isAsleep");
      System.out.println(p[0].isAsleep());
      System.out.println(p[1].isAsleep());
      System.out.println(p[2].isAsleep());

      System.out.println("\n\n\n super metod");

      System.out.println( p[3] );

      p[3].type();

   }
}
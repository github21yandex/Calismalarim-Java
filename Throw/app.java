package Throw;

public class app {
    public int sayi2 = 9;

    public static void main(String[] args) {

        OzelSayi1 ozelSayi1 = new OzelSayi1();
        System.out.println("ozelSayi = " + ozelSayi1.getA());
        
        OzelSayi2 ozelSayi2 = new OzelSayi2();
        System.out.println("ozelSayi2 = " + ozelSayi2.getA());

        OzelSayi3 ozelSayi3 = new OzelSayi3();
        System.out.println("ozelSayi3 = " + ozelSayi3.getA());

        OzelSayi4 ozelSayi4 = new OzelSayi4();
        System.out.println("ozelSayi4 = " + ozelSayi4.getA());
        
    }

    static class OzelSayi1{
        private int a = 11;
      
        public int getA() {
            return a;
        }
    }

    private static class OzelSayi2{
        private int a = 13;

        public int getA(){
            return a;
        }
    }
    
    public static class OzelSayi3{
        private int a = 15;

        public int getA(){
            return a;
        }
    }  

}

class OzelSayi4 {
    private int a = 17;
  
    public int getA() {
        return a;
    }
}
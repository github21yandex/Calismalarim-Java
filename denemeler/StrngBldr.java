package denemeler;

public class StrngBldr {

    public static void main(final String[] args) {

        StringBuilder kelime =  new StringBuilder("EKAUYLMAKUL");

        System.out.print(kelime.indexOf("K")+ "\n\n");

        System.out.print(kelime.substring(3,5)+ "\n\n");

        System.out.print(kelime.charAt(3));

        kelime.setCharAt(3, 'x');
       
        
        System.out.print(kelime + "\n\n");

        String kelime1 = "hello";
        String kelime2 = kelime1;
        System.out.println(kelime1 + kelime2 + "\n\n");
        kelime1 = "KELLO";
        System.out.println(kelime1 + kelime2 + "\n\n");
    }

    
}
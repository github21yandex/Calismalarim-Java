package denemeler;

public class Reverse{

    

    public static void main(String[] args){

        String kelime = "merhaba";
        String cumle = "ali babanın bir çiftliği var";

        kelime = reverse(kelime);
        System.out.println(kelime);

        System.out.println(cumle.indexOf("ba"));
    
    }


    public static String reverse(String s){

        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            ret = s.charAt(i) + ret;
        }
    
        return ret;
    
    }

}


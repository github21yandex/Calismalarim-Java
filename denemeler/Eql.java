package denemeler;

public class Eql{
    public static void main(String[] args){
        String user = "Jorman";
        String user2 = "Jorman";

        StringBuilder sb = new StringBuilder("Jorman");

        if(user.equals(sb.toString()))
            System.out.println("Same1");

        if(user == sb.toString())
            System.out.println("Same2");
        
        if(user.compareTo(sb.toString()) == 0)
            System.out.println("Same3");

        if(user == user2)
            System.out.println("Same4");


    }
}
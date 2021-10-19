package A_VeriYapilari.LnkdList;

import java.util.LinkedList;

public class LnkdList {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        list.add(1, "z");

        System.out.println(    list );
      

    }
    
}



package denemeler;

import java.util.ArrayList;

public class contains {
    public static void main(String[] args) {

        ArrayList<Araba> list = new ArrayList<Araba>();

        list.add(new Araba("C", 1990));
        list.add(new Araba("A", 1990));
        list.add(new Araba("B", 1991));
        list.add(new Araba("C", 1992));
        list.add(new Araba("D", 1993));
        list.add(new Araba("C", 1994));

        //Araba araba = new Araba("C", 1992);

        for (Araba arb : list) {
            System.out.println(arb.model + "  " + arb.yil);
        }

        



    }

    
}

class Araba{
    String model;
    int yil;

    public Araba(String model, int yil) {
        this.model = model;
        this.yil = yil;
    }
    
}

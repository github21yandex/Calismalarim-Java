package A_VeriYapilari.Final2;

public class App {

    public static void main(String[] args) {

        Odev4Graph<Integer> g1 = new Odev4Graph<>();
        Odev4Graph<Integer> g2 = new Odev4Graph<>();

        YonluIntGraph. addVerties(g1);
        YonluIntGraph. addVerties(g2);

        System.out.println( g1.equals(g2) );
        System.out.println(g1.equals2(g2) );
        



    }
    
}

package A_VeriYapilari.Final2;

public class YonluIntGraph {

    public static void addVerties(Odev4Graph<Integer> lg){

        for (int i = 0; i < 6; i++) {
            lg.addVertex(i);
        }

        lg.addEdge(0, 1);
        lg.addEdge(0, 3);
        lg.addEdge(1, 3);  
        lg.addEdge(1, 4);
        lg.addEdge(2, 0);
        lg.addEdge(2, 3);
        lg.addEdge(2, 5);
        lg.addEdge(3, 4);
        lg.addEdge(3, 5);
        lg.addEdge(3, 6);
        lg.addEdge(4, 6);
        lg.addEdge(6, 5);
        

    }
}

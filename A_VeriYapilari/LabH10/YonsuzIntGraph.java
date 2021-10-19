package A_VeriYapilari.LabH10;

public class YonsuzIntGraph {
    public static void addVerties(LabGraph<Integer> lg){
        for (int i = 0; i < 9; i++) {
            lg.addVertex(i);
        }

        lg.addEdge(0, 1, 4);
        lg.addEdge(0, 7, 8);
        lg.addEdge(1, 7, 11);
        lg.addEdge(7, 8, 7);
        lg.addEdge(1, 2, 8);
        lg.addEdge(6, 7, 1);
        lg.addEdge(2, 8, 2);
        lg.addEdge(6, 8, 6);
        lg.addEdge(2, 3, 7);
        lg.addEdge(2, 5, 4);
        lg.addEdge(5, 6, 2);
        lg.addEdge(3, 5, 14);
        lg.addEdge(3, 4, 9);
        lg.addEdge(4, 5, 10);
    }
}

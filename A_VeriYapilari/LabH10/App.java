package A_VeriYapilari.LabH10;

public class App{
    public static void main(String[] args) {
        LabGraph<Integer> lg = new LabGraph<Integer>();

        //YonsuzIntGraph.addVerties(lg);

        YonluIntGraph.addVerties(lg);

        System.out.println(lg);

        for (Edge<Integer> edge : lg.vertices.get(0).edges) {
            System.out.println(edge.from.value + " " + edge.to.value + " " + edge.weight);
        }

        for (Edge<Integer> edge : lg.edges.get(0) ) {
            System.out.println(edge.from.value + " " + edge.to.value + " " + edge.weight);
        }

        lg.inDegree(0);
        

        
    }
}
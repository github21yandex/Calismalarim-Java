package A_VeriYapilari.LabH10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {

        if(this.verticesMap.get(deger) == null){
            return -1;
        }

        return this.edges.get(deger).size();
    }

    @Override
    public int inDegree(T deger) {

        int count = 0;

        if(this.verticesMap.get(deger) == null){
            return -1;
        }

        Map< Vertex<T>, List<Edge<T>> > EdgeListIn = new HashMap<>();

        for (Vertex<T> vertex1 : vertices) {

            List<Edge<T>> list = new ArrayList<Edge<T>>();
            EdgeListIn.put(vertex1, list);

            for (Vertex<T> vertex2 : vertices) {
                for (Edge<T> edge : vertex2.edges) {

                    if(edge.to.value.equals(vertex1.value))
                        EdgeListIn.get(vertex1).add(edge);
                }
            }
        }

       System.out.println( "bura" );
       for (Edge<T> edge : EdgeListIn.get(vertices.get(3))) {
        System.out.println( edge.from.value );
       }
       


        for (Vertex<T> vertex : vertices) {
            for (Edge<T> edge : vertex.edges) {
                if(edge.to.value.equals(deger))
                    count++;
            }
        }

        return count;


    }
}
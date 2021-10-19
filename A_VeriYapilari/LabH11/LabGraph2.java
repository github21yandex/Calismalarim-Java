
package A_VeriYapilari.LabH11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LabGraph2<T> extends AbstractGraph2<T> {

    @Override
    protected Object clone() throws CloneNotSupportedException {

        LabGraph2<T> newGraph = new LabGraph2<T>();

        for (Vertex<T> vertex : this.vertices) {

            newGraph.addVertex(vertex.value);

        }

        for (Vertex<T> vertex : this.vertices) {
            for (Edge<T> edge : vertex.edges) {

                newGraph.verticesMap.get(vertex.value).edges.add(new Edge<T>(newGraph.verticesMap.get(edge.from.value),
                        newGraph.verticesMap.get(edge.to.value), edge.weight));
            }

        }
        return newGraph;
    }

    @Override
    public void removeVertex(T deger) {

        Vertex<T> vertex = this.verticesMap.get(deger);

        for (Vertex<T> vrtx : this.vertices) {

            for (Iterator<Edge<T>> itr = vrtx.edges.iterator(); itr.hasNext();) {
                Edge<T> edge = itr.next();
                if (edge.from.equals(vertex) || edge.to.equals(vertex)) {
                    itr.remove();
                }
            }
        }

        this.verticesMap.remove(vertex.value);
        this.vertices.remove(vertex);

    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> topologicalSort() {

        List<T> list = new ArrayList<T>();

        
        LabGraph2<T> newGraph = new LabGraph2<T>();
        
        try {
            
            newGraph = (LabGraph2<T>) this.clone();

        } catch (CloneNotSupportedException e) { e.printStackTrace(); }

        while(newGraph.vertices.size() != 0){

            for (Vertex<T> vertex : newGraph.vertices) {
                if( newGraph.inDegree(vertex.value) == 0){
                    list.add(vertex.value);
                    newGraph.removeVertex(vertex.value);
                    break;
                }
            }

            break;
        }
        

        return list;
    }
}


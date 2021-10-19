package A_VeriYapilari.LabH12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {
    @Override
    public List<T> dfs(T baslangic) {

        Stack<T> stack       = new Stack<T>();
        Stack<T> sortedStack = new Stack<T>();
        ArrayList<T> visited = new ArrayList<T>();

        stack.push(baslangic);
        T currentItem;

        while( !stack.isEmpty() ){

            currentItem = stack.pop();

            if(visited.contains(currentItem)){
                continue;
            }

            visited.add(currentItem);

            for (Edge<T> edge : this.verticesMap.get(currentItem).edges) {
                sortedStack.add(edge.to.value);
            }
            
            sortedStack.sort(null);

            while ( !sortedStack.isEmpty() ) {
                stack.push( sortedStack.pop() );
            }
            
        }
        
        return visited;

    }
    
    @Override
    public List<T> bfs(T baslangic) {
        
        Queue<T> queue  = new LinkedList<T>();
        Stack<T> sortedStack = new Stack<T>();
        ArrayList<T> visited = new ArrayList<T>();

        queue.add(baslangic);
        T currentItem;

        while( !queue.isEmpty() ){

            currentItem = queue.poll();

            if(visited.contains(currentItem)){
                continue;
            }

            visited.add(currentItem);

            for (Edge<T> edge : this.verticesMap.get(currentItem).edges) {
                sortedStack.add(edge.to.value);
            }
            
            sortedStack.sort(null);

            // while ( !sortedStack.isEmpty() ) {
            //     queue.add( sortedStack.pop() );
            // }

            for (T value : sortedStack) {
                queue.add( value );
            }
            sortedStack.clear();
            
        }
        
        return visited;



    }
}


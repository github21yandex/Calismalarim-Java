package A_VeriYapilari.LabH5;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public abstract class BinarySearchTree<T extends Comparable<T>> {
    private BTNode<T> root;

    public BinarySearchTree(BTNode<T> root) {
        this.root = root;
    }

    public BinarySearchTree() { }

    public BTNode<T> getRoot() {
        return root;
    }

    public BTNode<T> find(BTNode<T>node, T value){
        if(node==null || node.value==value)
            return node;
        else if(value.compareTo(node.value)<0)
            return find(node.left, value);
        else
            return find(node.right, value);
    }

    public boolean contains(T value){
        return find(root, value)!=null;
    }

    public void add(T value){
        add(root, value);
    }

    private void add(BTNode<T> node, T value) {
        if(root==null) {
            root = new BTNode<>(value, null, null);
            return;
        }
        if(value.compareTo(node.value)<0) {
            if(node.left==null)
                node.left = new BTNode<>(value, null, null);
            else
                add(node.left, value);
        }
        else if(value.compareTo(node.value)>0){
            if(node.right==null)
                node.right=new BTNode<>(value, null, null);
            else
                add(node.right, value);
        }
        else throw new RuntimeException("Eleman ağaçta mevcut!");
    }

    public int depth(T value){
        BTNode<T> node = new BTNode<T>(null, null, null);
        node = getRoot();
        int count = 0;

        while(true){
            if(node==null || node.value==value){
                return count;
            }
                
            else if(value.compareTo(node.value)<0){
                count++;
                node = node.left;
            }
            
            else{
                count++;
                node = node.right;
        
            }
        }
        
    }

    public void print(){

        BTNode<T> node = new BTNode<T>(null, null, null);

        Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();

        Stack<BTNode<T>> stack = new Stack<>();
        

    
        queue.add(getRoot());
        stack.push(getRoot());

        while( ! queue.isEmpty() ){

            node = queue.poll();
            

            if(node.left != null){
                stack.push(node.left);
                queue.add(node.left);
            }

            if(node.right != null){
                stack.push(node.right);
                queue.add(node.right);
            }
        }

        for (BTNode<T> btNode : stack) {
            System.out.println(btNode.value);
        }
        int depth = depth(stack.peek().value);
        int column = (int)Math.pow(2, depth);
        column = column*2 - 1;
        int row = depth + 1;

        boolean [][] array = new boolean [row][column];

        
        
        for (int i = 0; i < row; i++) {
            int f = (int)Math.pow(2, depth-i) -1;
            int s = 2 * f + 1;
            for (int j = f; j < column; j += s+1 ){
                array[i][j] = true;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(array[i][j] == true)
                    System.out.printf("*");

                if(array[i][j] == false)
                    System.out.printf(" ");
            }

            System.out.println("\n");
        }

        Queue<BTNode<T>> Q = new LinkedList<>();
        for (BTNode<T> btNode : stack) {
            Q.add(btNode);
        }
        

        
        for (int i = 1; i < row; i++) {
            //if(Q.isEmpty()){ break;} 

            for (int j = 0; j < column; j++) {

                //if(Q.isEmpty()){ break; }
                if(array[i][j] == true){
                    if(array[i-1][((int)Math.pow(2, depth-i+1) + j +j)/2 ] == false){
                        array[i][j] = false;
                        continue;
                    }
                    node = Q.poll();
                    if(node.left == null){
                        array[i][j] = false;
                    }
                }
                else{
                    continue;
                }
                
                for (int j2 = j+1; j2 < column; j2++) {
                    if(array[i][j2] == true){

                        if(node.right == null){
                            array[i][j2] = false;
                        }
                        j = j2;
                        break;

                    }
                }
                
                   

            
                   
            }
            

            
        }

        Q.clear();
        

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(array[i][j] == true)
                    System.out.printf("*");

                if(array[i][j] == false)
                    System.out.printf(" ");
            }

            System.out.println("\n");
        }


        for (BTNode<T> btNode : stack) {
            Q.add(btNode);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(array[i][j] == true)
                    
                    System.out.printf("%d", (int) (Q.poll().value));

                if(array[i][j] == false)
                    System.out.printf(" ");
            }

            System.out.println("\n");
        }
 
        
    }

    @Override
    protected abstract Object clone() throws CloneNotSupportedException;
    public abstract BTNode<T> successor(T value);
    public abstract BTNode<T> predecessor(T value);
    public abstract BTNode<T> findParent(BTNode<T> node);
}


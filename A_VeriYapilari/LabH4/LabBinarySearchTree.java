package A_VeriYapilari.LabH4;

import java.util.LinkedList;
import java.util.Queue;

public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
        //Bu metodu değiştirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu değiştirmeyin
        super(root);
        
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        LabBinarySearchTree<T> cln = new LabBinarySearchTree<>();
        
        BTNode<T> node;

        Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();

        queue.add( getRoot() );

        cln.add(getRoot().value);

        while( ! queue.isEmpty() ){

            node = queue.poll();
            

            if(node.left != null){
                cln.add(node.left.value);
                queue.add(node.left);
            }

            if(node.right != null){
                cln.add(node.right.value);
                queue.add(node.right);
            }
        }
    

        return cln;
    }

    @Override
    public BTNode<T> successor(T value) {

        BTNode<T> node = find(getRoot(), value);

        if(node.right != null){
            node = node.right;
        }
        else{ return null;}

        
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    @Override
    public BTNode<T> predecessor(T value) {

        BTNode<T> node = find(getRoot(), value);

        if(node == null){
            return node;
        }

        if(node.left != null){

            node = node.left;
        }else{return null;}

        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {

        BTNode<T> parent = getRoot();

        while(parent.left != null || parent.right != null){

            if(parent.left == node || node == parent.right){
                return parent;
            }
            else if(parent.value.compareTo(node.value) > 0){
                parent = parent.left;
            }
            else{
                parent = parent.right;
            }
        }

        return null;

    }


}


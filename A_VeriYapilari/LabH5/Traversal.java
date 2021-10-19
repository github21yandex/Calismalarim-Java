package A_VeriYapilari.LabH5;

public class Traversal {

    public static<T> String inOrder(BTNode<T> node) {

        if(node.left != null && node.right != null){
            return  inOrder(node.left).toString() +" "+ node.value.toString() +" "+ inOrder(node.right).toString();
        }
        else if (node.left != null && node.right ==null){
            return inOrder(node.left).toString() +" "+ node.value.toString();
        }
        else if (node.left == null && node.right !=null){
            return node.value.toString() +" "+ inOrder(node.right).toString();
        }
        else{
            return node.value.toString();
        }
    }

    public static<T> String preOrder(BTNode<T> node) {

        if(node.left != null && node.right != null){
            return  node.value.toString() +" "+ preOrder(node.left).toString() +" "+ preOrder(node.right).toString();
        }
        else if (node.left != null && node.right ==null){
            return node.value.toString() +" "+ preOrder(node.left).toString();
        }
        else if (node.left == null && node.right !=null){
            return node.value.toString() +" "+ preOrder(node.right).toString();
        }
        else{
            return node.value.toString();
        }
            
    }

    public static<T> String postOrder(BTNode<T> node) {

        if(node.left != null && node.right != null){
            return  postOrder(node.left).toString() +" "+ postOrder(node.right).toString() +" "+ node.value.toString() ;
        }
        else if (node.left != null && node.right ==null){
            return postOrder(node.left).toString() +" "+ node.value.toString() ;
        }
        else if (node.left == null && node.right !=null){
            return postOrder(node.right).toString() +" "+ node.value.toString();
        }
        else{
            return node.value.toString();
        }
    }
}

package A_VeriYapilari.LabH5;

public class App {
    public static void main(String[] args) {
        LabBinarySearchTree<Integer> tree = new LabBinarySearchTree<>();

        tree.add(6);
        tree.add(2);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        System.out.println();

        tree.print();

        System.out.println();

        System.out.println(  Traversal.preOrder(tree.getRoot()) );

        System.out.println();

        System.out.println(  Traversal.inOrder(tree.getRoot()) );

        System.out.println();

        System.out.println(  Traversal.postOrder(tree.getRoot()) );
    }
}

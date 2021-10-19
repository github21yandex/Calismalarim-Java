package A_VeriYapilari.LabH4;

public class App {
    @SuppressWarnings("unchecked")
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

        tree.print();

        System.out.println(tree.findParent(tree.find(tree.getRoot(), 2)).value);
        
        
        try {
            
            ((LabBinarySearchTree<Integer>) tree.clone()).print()  ;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
    }



}



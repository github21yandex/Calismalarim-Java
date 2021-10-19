package A_VeriYapilari.LabH7;

public class Rotator {

    public static <T> BTNode<T> solaDondur(BTNode<T> k1) {

        BTNode<T> tmp = new BTNode<T>(k1.value, k1.left, k1.right);

        if (k1.right.left == null) {
            k1.right.left = k1;
            k1.right = null;
            return tmp.right;
        } else {

            k1.right = k1.right.left;
            tmp.right.left = k1;
            return tmp.right;

        }

    }

    public static <T> BTNode<T> sagaDondur(BTNode<T> k2) {

        BTNode<T> tmp = new BTNode<T>(k2.value, k2.left, k2.right);

        if (k2.left.right == null) {
            k2.left.right = k2;
            k2.left = null;
            return tmp.left;
        } else {

            k2.left = k2.left.right;
            tmp.left.right = k2;
            return tmp.left;

        }

    }

    public static <T> BTNode<T> solaSagaDondur(BTNode<T> k3) {

        solaDondur(k3.left);
        return sagaDondur(k3);
    }

    public static <T> BTNode<T> sagaSolaDondur(BTNode<T> k1) {

        k1.right = sagaDondur(k1.right);
        return solaDondur(k1);
    }
}

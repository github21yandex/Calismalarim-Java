package A_VeriYapilari.vize2;


public class App {

    public static void main(String[] args) {
        String str = " 3 5 * 7 3 / * ";

        ExpressionTree tree = Odev2.postfixToExpressionTree(str);
        //System.out.println(tree.getRoot().value);
        Odev2.print(tree.getRoot());

        System.out.println("evaluate = " + Odev2.evaluateExpressionTree(tree));
    }
    
}

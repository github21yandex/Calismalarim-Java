package A_VeriYapilari.vize2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Odev2 {
    /**
     * Postfix biçiminde verilen metni ExpressionTree sınıfına dönüştürür
     * @param girdi postfix girdi metni
     * @return Oluşturulan ifade ağacı
     */
    public static ExpressionTree postfixToExpressionTree(String girdi){

        ExpressionTree tree = new ExpressionTree();
        String [] array = splitToTokens(girdi);
        Stack< BTNode<String> > stack = new Stack<>();
        BTNode<String> node;
        
        
        for (String str : array) {
            
            if(isNumber(str)){
                stack.push(new BTNode<String>(str, null, null));
            }
            else{
                node = new BTNode<String>(str, null, null);
                node.right = stack.pop();
                node.left  = stack.pop();
                stack.push(node); 
            }
        }

        tree.root = stack.pop();
        
        return tree;
    }

    /**
     * Parametre olarak verilen ifade ağacını değerlendirir(sonucunu hesaplar).
     * @param agac İfade ağacı
     * @return İfade ağacının sonucu
     */
    public static int evaluateExpressionTree(ExpressionTree agac){
        
        switch (agac.getRoot().value) {

            case "*":
                return evaluateExpressionTree(new ExpressionTree(agac.root.left)) * evaluateExpressionTree(new ExpressionTree(agac.root.right));
            
            case "/":
                try {
                    return evaluateExpressionTree(new ExpressionTree(agac.root.left)) / evaluateExpressionTree(new ExpressionTree(agac.root.right));
                
                } catch (ArithmeticException e) {
                    return 1;
                }

                // if(evaluateExpressionTree(new ExpressionTree(agac.root.right)) == 0){
                //     return 1;
                // }
                // else{
                //     return evaluateExpressionTree(new ExpressionTree(agac.root.left)) / evaluateExpressionTree(new ExpressionTree(agac.root.right));
                // }

            case "+":
                return evaluateExpressionTree(new ExpressionTree(agac.root.left)) + evaluateExpressionTree(new ExpressionTree(agac.root.right));

            case "-":
                return evaluateExpressionTree(new ExpressionTree(agac.root.left)) - evaluateExpressionTree(new ExpressionTree(agac.root.right));
            
            default :
                return Integer.parseInt(  agac.getRoot().value  ) ;
        }

    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////

    private static String[] splitToTokens(String girdi) {
		StringTokenizer t = new StringTokenizer(girdi, "+-*/^() ", true);
		List<String> tokenList = new ArrayList<>();
		while (t.hasMoreTokens()) {
			String s = t.nextToken().trim();
			if (!s.equals(""))
				tokenList.add(s);
		}
		String[] tl = new String[tokenList.size()];
		tokenList.toArray(tl);
		return tl;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    
    private static boolean isNumber(String str){
        
        for (Character c : str.toCharArray()) {
            if(Character.isDigit(c) || c == '.') {
                return true;
            }
        }
        return false;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public static <T extends Comparable<T>> void print(BTNode<T> root) {
        BTNode<T> node = new BTNode<T>(null, null, null);

        Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();

        Stack<BTNode<T>> stack = new Stack<>();
        

    
        queue.add(root);
        stack.push(root);

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
        
        int depth = depth(stack.peek().value, root);
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
                    
                    System.out.print((T) (Q.poll().value));

                if(array[i][j] == false)
                    System.out.printf(" ");
            }

            System.out.println("\n");
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////
    
    public static <T extends Comparable<T>>  int depth(T value, BTNode<T> root) {
        BTNode<T> node = new BTNode<T>(null, null, null);
        node = root;
        int count = 0;

        while (true) {
            if (node == null || node.value == value) {
                return count;
            }

            else if (value.compareTo(node.value) < 0) {
                count++;
                node = node.left;
            }
            
            else{
                count++;
                node = node.right;
        
            }
        }
        
    }
}

package A_VeriYapilari.LabH2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {

    public static int postfixDegerlendir(String girdi){

        Stack<Integer> stack = new Stack<Integer>();

        String[] stringArray = splitToTokens(girdi);


        for (String d : stringArray) {
            
            try {
                stack.push(  Integer.parseInt(d)  );
            } catch (Exception e) {

                switch (d) {
                    case "+":
                        stack.push(  stack.pop() + stack.pop()  );
                        break;

                    case "-":
                        stack.push(  stack.pop() - stack.pop()  );
                        break;

                    case "*":
                        stack.push(  stack.pop() * stack.pop()  );
                        break;

                    case "/":
                        stack.push(  stack.pop() / stack.pop()  );
                        break;

                    default:
                        break;
                }
            }

           
           
        }

        return stack.peek();
    }



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



    public static void main(String[] args){

        String girdi =  "7 11 * 3 +";

        System.out.println(postfixDegerlendir(girdi));
        
        

    }







}

package A_VeriYapilari.LabH2;

import java.util.Stack;
public class H2Stack {
    

    

    public static void main(String[] args) {

       

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> reversedStack = new Stack<Integer>();

        stack.push(6);
        stack.push(9);
        stack.push(11);

        int lastIndex = 0;
        
        if (!stack.isEmpty()){
           lastIndex = stack.size()-1;
           
           for (int i = lastIndex; i >= 0; i--) {
               reversedStack.push(stack.get(i));
           }
           
           
        }

        System.out.printf("%d  %d  %d\n",     stack.get(0), stack.get(1), stack.get(2)      );
        System.out.printf("%d  %d  %d\n",     reversedStack.get(0), reversedStack.get(1), reversedStack.get(2)      );
        
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        s1.push(1); s2.push(1);
        s1.push(2); s2.push(2);
        s1.push(3); s2.push(44);
        s1.push(4); s2.push(4);

        int lastIndex1 = s1.size();
        int lastIndex2 = s2.size();

        if (lastIndex1 != lastIndex2){
            System.out.println(false);
            
        }

        for (int i = 0; i < lastIndex1; i++) {
            if (  s1.get(i).compareTo(s2.get(i)) != 0  ){
                System.out.println(false);
            } 
        }

        System.out.println(true);
    
    
    }

}

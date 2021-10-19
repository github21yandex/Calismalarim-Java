package denemeler;

import java.util.Stack;

public class sortedStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        stack.push("c");
        stack.push("a");
        stack.push("b");

        System.out.println(stack);
        stack.sort(null);
        System.out.println(stack);
    
    }
}

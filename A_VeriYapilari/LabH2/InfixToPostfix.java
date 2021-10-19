package A_VeriYapilari.LabH2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class InfixToPostfix {
	public static String infixToPostfix(String girdi) {

		Stack<String> outputStack = new Stack<String>();
		Stack<String> opStack = new Stack<String>();

		String[] stringArray = splitToTokens(girdi);

		for (String d : stringArray) {
			try {
				Integer.parseInt(d);
				outputStack.push(d);

			} catch (Exception e) {

				if (d.equals("(")) {
					opStack.push(d);

				} else if (d.equals(")")) {

					while (!opStack.isEmpty()) {
						if (!opStack.peek().equals("(")) {
							outputStack.push(opStack.pop());
						} else {
							opStack.pop();
							break;
						}
					}

				} else { //sembol bir operand ise ve opStack te kendisinden daha öncelikli bir operand yoksa opStack i outputStack e
						 //aktar. en sonda d yi output Stack e yerleştir.
						 //d den daha öncelikli bir operand opStack te varsa d yi opStack e aktar.
					
					if (d.equals("+") || d.equals("-")) { 

						while (!opStack.isEmpty() && !opStack.peek().equals("(")) {

							outputStack.push(opStack.pop());
						}

						opStack.push(d);

					} else {
						opStack.push(d);
					}

				}
			}
		}

		while(!opStack.isEmpty()){
			outputStack.push(opStack.pop());
		}
		

		String result = "";
		for (String string : outputStack) {
			result += string + " ";
		}
		
		return result.substring(0, result.length()-1);

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

	public static void main(String[] args) {

		String girdi = "4*4+4*4+4-4*4";

		System.out.println(infixToPostfix(girdi));
		

	}
}

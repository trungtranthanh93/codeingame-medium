/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * BaiToanLop1.java, Oct 21, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author trung.tran
 *
 */
public class BaiToanLop1 {
	public static void main(String[] args) {
		// System.out.println("2".matches("\\d*"));
		Scanner in = new Scanner(System.in);

		String answer = in.nextLine();

		int i = 0;
		for (i = 0; i < answer.length(); i++) {
			if (answer.charAt(i) == '=') {
				break;
			}

		}
		float x1 = caculateExpression(convertInfixToPostfix(answer.substring(0, i)));
		float x2 = caculateExpression(convertInfixToPostfix(answer.substring(i + 1)));
		System.out.println(x1 + "/" + x2);
		System.out.println(x1-x2);
	}

	static boolean caculateTwoNumber(String[] answer, int soSanh) {
		return true;
	}

	static float caculateExpression(List<String> expression) {
		Stack<String> stack = new Stack<>();
		for (String i : expression) {
			if (i.trim().matches("\\d*")) {
				stack.push(i);
			} else {
				float x1 = Float.parseFloat(stack.pop());
				float x2 = Float.parseFloat(stack.pop());
				float result = caculate(x1, x2, i);
				stack.push(Float.toString(result));
			}
		}
		return Float.parseFloat(stack.pop());
	}

	/**
	 * @param x1
	 * @param x2
	 * @param i
	 * @return
	 */
	private static float caculate(float x1, float x2, String i) {
		switch (i) {
		case "+":
			return x1 + x2;
		case "-":
			return x2 - x1;
		case "*":
			return x1 * x2;
		case "/":
			return x2 / x1;
		}
		return 0;
	}

	/**
	 * @param expression
	 * @return
	 */
	private static List<String> convertInfixToPostfix(String expression) {
		Stack<String> postfix = new Stack<>();
		List<String> output = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char indexOfI = expression.charAt(i);
			if (indexOfI == '(') {
				postfix.push("(");
			}
			if (indexOfI == ')') {
				while (postfix.peek() != "(") {
					output.add(postfix.pop());
				}
				postfix.pop();
			}
			if (isOperator(indexOfI)) {

				while (!postfix.isEmpty() && isOperator(postfix.peek().charAt(0))
						&& caculatePriority(indexOfI) < caculatePriority(postfix.peek().charAt(0))) {
					output.add(postfix.pop());
				}
				postfix.push(Character.toString(indexOfI));
			}
			if (isOperand(indexOfI)) {
				String operand = "";
				while (i < expression.length() && isOperand(expression.charAt(i))) {
					operand += expression.charAt(i);
					i++;
				}
				i = i - 1;
				output.add(operand);
			}
		}
		while (!postfix.isEmpty()) {
			output.add(postfix.pop());
		}
		return output;
	}

	private static int caculatePriority(char op) {
		switch (op) {
		case '(':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;

		}
		return 0;
	}

	private static boolean isOperator(char op) {
		if (op == '+' || op == '-' || op == '*' || op == '/') {
			return true;
		}
		return false;
	}

	private static boolean isOperand(char op) {
		if (isOperator(op) || '(' == op || op == ')') {
			return false;
		}
		return true;
	}

}

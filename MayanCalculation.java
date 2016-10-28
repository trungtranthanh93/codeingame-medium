/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * MayanCalculation.java, Oct 12, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class MayanCalculation {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int H = in.nextInt();
		List<String[]> list = new ArrayList<String[]>();
		String[] numeral = new String[H];
		for (int i = 0; i < H; i++) {
			numeral[i] = in.next();
		}
		String[] numberCopy = numeral;
		for (int j = 0; j < 20; j++) {
			String[] number = new String[H];
			for (int i = 0; i < H; i++) {
				number[i] = numberCopy[i].substring(0, L);

				numberCopy[i] = numberCopy[i].substring(L, numberCopy[i].length());
			}
			list.add(number);
		}
		int S1 = in.nextInt();
		String num1Line[] = new String[S1];
		for (int i = 0; i < S1; i++) {
			num1Line[i] = in.next();
		}
		int S2 = in.nextInt();
		String num2Line[] = new String[S2];
		for (int i = 0; i < S2; i++) {
			num2Line[i] = in.next();
		}
		String operation = in.next();
		List<String[]> lNumber1 = getListStringNumber(S1, H, num1Line);
		List<String[]> lNumber2 = getListStringNumber(S2, H, num2Line);
		int[] arrayNumber1 = converToArrayNumber(lNumber1, list);
		int[] arrayNumber2 = converToArrayNumber(lNumber2, list);
		long number1 = convertToNumber(arrayNumber1);
		long number2 = convertToNumber(arrayNumber2);
		System.out.println(number1 * number2);
		System.out.println(number1 + operation + number2 + " = " + result(number1, number2, operation));
		long result = result(number1, number2, operation);
		int[] result1 = divideNumberToListInt(result, 20);
		for (long i : result1)
			System.out.println(i);
		printArrayNumber(result1, list);
		in.close();
	}

	static boolean compareArrayString(String[] x, String[] y) {
		for (int i = 0; i < x.length; i++) {
			if (!x[i].equals(y[i])) {
				return false;
			}
		}
		return true;
	}

	static List<String[]> getListStringNumber(int S1, int H, String num1Line[]) {
		List<String[]> lNumber = new ArrayList<String[]>();
		for (int j = 0; j < S1; j = j + H) {
			String[] number = new String[H];
			for (int i = 0; i < H; i++) {
				number[i] = num1Line[i + j];
			}
			lNumber.add(number);
		}
		return lNumber;
	}

	static int[] converToArrayNumber(List<String[]> lNumber1, List<String[]> list) {
		int[] arrayNumber1 = new int[lNumber1.size()];
		for (int i = 0; i < lNumber1.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (compareArrayString(lNumber1.get(i), list.get(j))) {
					arrayNumber1[i] = j;
					break;
				}
			}
		}
		return arrayNumber1;
	}

	static long convertToNumber(int[] arrayNumber1) {
		int output = 0;
		for (int i = 0; i < arrayNumber1.length; i++) {
			output += arrayNumber1[i] * Math.pow(20, arrayNumber1.length - 1 - i);
		}
		return output;
	}

	static long result(long number1, long number2, String operation) {
		long result = 0;
		switch (operation) {
		case "*":
			result = number1 * number2;
			break;
		case "+":
			result = number1 + number2;
			break;
		case "/":
			result = number1 / number2;
			break;
		case "-":
			result = number1 - number2;
			break;
		}
		return result;
	}

	static int[] divideNumberToListInt(long n, int m) {
		long k = n;
		long t = n;
		long v = n;
		int count = 1;
		while (t >= m) {
			t = t / m;
			count++;
		}
		int[] result = new int[count];

		while (v > m) {
			int count1 = 0;
			while (k >= m) {
				k = k / m;
				count1++;
			}
			result[count1] = (int) k;
			long h = (long) (k * Math.pow(m, count1));
			k = v - h;
			v = k;
			count1 = 0;
		}
		result[0] = (int) v;
		return result;
	}

	static void printNumber(int i, List<String[]> lNumber) {
		for (String j : lNumber.get(i)) {
			System.out.println(j);
		}
	}

	static void printArrayNumber(int[] arrayNumber, List<String[]> lNumber) {
		for (int i = arrayNumber.length - 1; i >= 0; i--) {
			printNumber(arrayNumber[i], lNumber);
		}
	}
}

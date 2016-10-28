/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * StringNumber.java, Oct 14, 2016,  trung.tran
 */
package tests;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author trung.tran
 *
 */
public class StringNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String strNumber = in.nextLine();
		System.out.println(isNumber(strNumber));
	}

	static boolean isNumber(String number) {
		String parrent = "[0-9]*";
		if (Pattern.matches(parrent, number)) {
			return true;
		}
		return false;
	}
}

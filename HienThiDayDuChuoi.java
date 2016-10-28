/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * HienThiDayDuChuoi.java, Oct 26, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.List;

/**
 * @author trung.tran
 *
 */
public class HienThiDayDuChuoi {
	static String unpacking(String str) {
		if (str.lastIndexOf("(") != -1) {
			int i = str.lastIndexOf("(");
			int j = str.indexOf(")", i);
			String substring = str.substring(i + 1, j);
			StringBuilder nubmer = new StringBuilder();
			StringBuilder strCp = new StringBuilder(str);
			while (j < str.length() - 1 && (str.charAt(j + 1) + "").matches("\\d+")) {
				nubmer.append(str.charAt(j + 1));
				j++;
			}
			int count = Integer.parseInt(nubmer.toString());
			strCp.delete(i, j + 1);
			for (int k = 0; k < count; k++) {
				strCp.insert(i, substring);
			}
			return unpacking(strCp.toString());
		} else {
			return str;
		}

	}

	static String findMaxStringLoop(String string) {
		int max = 0;
		int i = 0;
		String maxStringLoop = "";
		while (i < string.length() && string.substring(i).length() > max) {
			char charAtI = string.charAt(i);
			int lastIndexOfI = string.lastIndexOf(charAtI);
			while (lastIndexOfI != -1) {
				int last = (lastIndexOfI * 2 - i > string.length()) ? string.length() : (lastIndexOfI * 2 - i);
				if (last < 0 || last <= lastIndexOfI) {
					break;
				}
				String subStringFromI = string.substring(i, lastIndexOfI);
				String subStringFromLastIndexOfI = string.substring(lastIndexOfI, last);
				if (subStringFromI.equals(subStringFromLastIndexOfI) && max < subStringFromI.length()) {
					max = subStringFromI.length();
					maxStringLoop = subStringFromI;
				} else {
					String subString = string.substring(i, lastIndexOfI);
					lastIndexOfI = subString.lastIndexOf(charAtI) + i;
				}
			}
			i++;
		}
		if (maxStringLoop.isEmpty()) {
			return "";
		}
		maxStringLoop = maxStringLoop + maxStringLoop;
		int count = countLoopCount(maxStringLoop);
		if (count != 0) {
			String subStringLoop = maxStringLoop.substring(0, maxStringLoop.length() / count);
			int indexOfStringLoop = string.indexOf(maxStringLoop);
			int length = maxStringLoop.length();
			int last = indexOfStringLoop + length + subStringLoop.length();
			if (last <= string.length()) {
				String AfterMaxStringLoop = string.substring(indexOfStringLoop + length, last);
				if (AfterMaxStringLoop.equals(subStringLoop)) {
					maxStringLoop = maxStringLoop + subStringLoop;
				}

			}
		}
		return maxStringLoop;
	}

	public static String getAllStringLoop(String string) {
		if ("".equals(string) || "".equals(findMaxStringLoop(string))) {
			return string;
		}
		String maxStringLoop = findMaxStringLoop(string);
		if (maxStringLoop.equals(string)) {
			int countLoopCount = countLoopCount(maxStringLoop);
			String packMaxString = "";
			if (countLoopCount > 0) {
				packMaxString = "("
						+ getAllStringLoop(maxStringLoop.substring(0, maxStringLoop.length() / countLoopCount)) + ")"
						+ countLoopCount;
			} else {
				packMaxString = getAllStringLoop(packMaxString);
			}
			return packMaxString;
		} else {
			int indexOfSubMaxString = string.indexOf(maxStringLoop);
			int indexOfEndSubMaxString = indexOfSubMaxString + maxStringLoop.length();
			String from0ToIndexOfMaxString = string.substring(0, string.indexOf(maxStringLoop));
			String fromIndexOfMaxStringToEnd = string.substring(indexOfEndSubMaxString, string.length());
			return getAllStringLoop(from0ToIndexOfMaxString) + getAllStringLoop(maxStringLoop)
					+ getAllStringLoop(fromIndexOfMaxStringToEnd);
		}

	}

	public static int countLoopCount(String string) {
		int count = 0;
		List<Integer> list = getListPrime(string.length());
		for (int i = list.size() - 1; i >= 0; i--) {
			int last = string.length() / list.get(i);
			String subString = string.substring(0, last);
			int k = last;
			while (k < string.length()) {
				String nextSubString = string.substring(k, k + last);
				if (nextSubString.equals(subString)) {
					k = k + last;
				} else {
					break;
				}
			}
			if (k == string.length()) {
				count = list.get(i);
				break;
			}
		}
		return count;

	}

	public static List<Integer> getListPrime(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
		list.add(n);
		return list;
	}

	public static void main(String[] args) {
		String s1 = unpacking("(a)10");
		System.out.println(s1);
		System.out.println(getAllStringLoop(s1));
	}

}

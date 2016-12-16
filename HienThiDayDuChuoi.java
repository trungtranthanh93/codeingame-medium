/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * HienThiDayDuChuoi.java, Oct 26, 2016,  trung.tran
 */
package tests;

import java.util.Stack;

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
		int countMax = 0;
		int i = 0;
		String subMaxStringLoop = "";
		String maxStringLoop = "";
		while (i < string.length()) {
			char charAtI = string.charAt(i);
			int lastIndexOfI = string.lastIndexOf(charAtI);
			while (lastIndexOfI != -1) {
				int last = (lastIndexOfI * 2 - i > string.length()) ? string.length() : (lastIndexOfI * 2 - i);
				if (last < 0 || last <= lastIndexOfI) {
					break;
				}
				String subStringFromI = string.substring(i, lastIndexOfI);
				String subStringFromLastIndexOfI = string.substring(lastIndexOfI, last);
				if (subStringFromI.equals(subStringFromLastIndexOfI)) {
					String maxStringCurrent = subStringFromI + subStringFromI;
					int count = countLoopCount(maxStringCurrent);
					String subStringLoop = maxStringCurrent.substring(0, maxStringCurrent.length() / count);
					int indexOfStringLoop = string.indexOf(maxStringCurrent);
					int length = maxStringCurrent.length();
					int lastAfterStringLoop = indexOfStringLoop + length + subStringLoop.length();
					if (lastAfterStringLoop <= string.length()) {
						String AfterMaxStringLoop = string.substring(indexOfStringLoop + length, lastAfterStringLoop);
						if (AfterMaxStringLoop.compareTo(subMaxStringLoop) < 0) {
							break;
						}
						if (AfterMaxStringLoop.equals(subStringLoop)) {
							maxStringCurrent = maxStringCurrent + subStringLoop;
							count = count + 1;
						}

					}
					if (maxStringCurrent.length() > maxStringLoop.length()) {
						maxStringLoop = maxStringCurrent;
						subMaxStringLoop = subStringLoop;
						countMax = count;
					} else {
						break;
					}
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
		System.out.println(maxStringLoop.substring(0, maxStringLoop.length() / countMax));
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
			String from0ToIndexOfMaxString = string.substring(0, indexOfSubMaxString);
			String fromIndexOfMaxStringToEnd = string.substring(indexOfEndSubMaxString, string.length());
			return getAllStringLoop(from0ToIndexOfMaxString) + getAllStringLoop(maxStringLoop)
					+ getAllStringLoop(fromIndexOfMaxStringToEnd);
		}

	}

	public static int countLoopCount(String string) {
		int count = 0;
		Stack<Integer> stack = getListPrime(string.length());
		while (!stack.isEmpty()) {
			int i = stack.pop();
			int last = string.length() / i;
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
				count = i;
				break;
			}
		}
		// System.out.println(count);
		return count;

	}

	public static Stack<Integer> getListPrime(int n) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				stack.push(i);
			}
		}
		stack.push(n);
		return stack;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String s1 = unpacking("(abc)2abcda(bcdef)2");
		System.out.println(getAllStringLoop(s1));
		// String s3 = unpacking("(ABC(EF)3)3");
		System.out.println(System.currentTimeMillis() - start);
	}

}

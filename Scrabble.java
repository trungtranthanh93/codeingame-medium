/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * Scrabble.java, Oct 14, 2016,  trung.tran
 */
package tests;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class Scrabble {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		String[] W = new String[N];
		for (int i = 0; i < N; i++) {
			W[i] = in.nextLine();
		}
		String LETTERS = in.nextLine();

		String result = "";
		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");
		// Arrays.sort(letters);
		Arrays.sort(W);
		for (String j : W) {
			if (j.length() <= LETTERS.length()) {
				if (compareWord(j, LETTERS)) {
					if (result == "") {
						result = j;
					} else {
						if (countScoreWord(j) > countScoreWord(result)) {
							result = j;
						}
					}
				}
			}
		}
		if (result == "") {
			System.out.println("invalid word");
		} else {
			System.out.println(result);
		}
		// System.out.println(countScoreWord("statute"));
		// System.out.println(countScoreWord("satire"));
	}

	static int countScoreCharOfWord(char input) {
		int count = 0;
		switch (input) {
		case 'e':
		case 'a':
		case 'i':
		case 'o':
		case 'n':
		case 't':
		case 'l':
		case 's':
		case 'u':
			count = 1;
			break;
		case 'd':
		case 'g':
			count = 2;
			break;
		case 'b':
		case 'c':
		case 'm':
		case 'p':
			count = 3;
			break;
		case 'f':
		case 'h':
		case 'v':
		case 'w':
		case 'y':
			count = 4;
			break;
		case 'k':
			count = 5;
			break;
		case 'j':
		case 'x':
			count = 8;
			break;
		case 'q':
		case 'z':
			count = 10;
			break;
		}
		return count;
	}

	static int countScoreWord(String word) {
		int total = 0;
		for (int i = 0; i < word.length(); i++) {
			total += countScoreCharOfWord(word.charAt(i));
		}
		return total;
	}

	static int compareTwoNumber(int x1, int x2) {
		return (x1 - x2);
	}

	static boolean compareWord(String word, String letter) {
		int count = 0;
		// List<Character> lsLetter = new ArrayList<Character>();
		/*
		 * for (int j = 0; j < letter.length(); j++) {
		 * lsLetter.add(letter.charAt(j)); }
		 */
		/*
		 * for (int i = 0; i < word.length(); i++) { for (int j = 0; j <
		 * lsLetter.size(); j++) { if (word.charAt(i) == lsLetter.get(j)) {
		 * count++; lsLetter.remove(j); break; } } }
		 */
		char[] charWord = word.toCharArray();
		char[] charLetter = letter.toCharArray();
		for (int i = 0; i < charWord.length; i++) {
			for (int j = 0; j < charLetter.length; j++) {
				if (charWord[i] == charLetter[j]) {
					count++;
					charLetter[j] = ' ';
					break;
				}
			}
		}
		if (count == word.length()) {
			return true;
		}
		return false;
	}
}

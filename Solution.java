/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * Solution.java, Oct 14, 2016,  trung.tran
 */
package tests;

/**
 * @author trung.tran
 *
 */
import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        
        String[] dictionary = new String[N];
        for (int i = 0; i < N; i++) {
            dictionary[i] = in.nextLine();
        }
        String LETTERS = in.nextLine();
        
        WordChecker checker = new WordChecker(LETTERS);
        WordScorer scorer = new WordScorer();
        int maxScore = 0;
        String maxWord = "";
        for (String word : dictionary) {
			if (checker.check(word)) {
				int score = scorer.scoreWord(word);
				if (score > maxScore) {
					maxScore = score;
					maxWord = word;
				}
			}
		}

        System.out.println(maxWord);
    }
}

class WordChecker {
	private Map<Character, Integer> letters = new HashMap<>();
	
	public WordChecker(String word) {
		for (Character chr : word.toCharArray()) {
			int count = getCountFromMap(chr, letters) + 1;
			letters.put(chr, count);
		}
	}

	private int getCountFromMap(Character chr, Map<Character, Integer> map) {
		return map.containsKey(chr) ? map.get(chr) : 0;
	}

	public boolean check(String word) {
		Map<Character, Integer> usedLetters = new HashMap<>();
		for (Character chr : word.toCharArray()) {
			int usedCount = getCountFromMap(chr, usedLetters) + 1;
			int availableCount = getCountFromMap(chr, letters);
			if (usedCount > availableCount) return false;
			usedLetters.put(chr, usedCount);
		}		
		return true;
	}
}

class WordScorer {
	private Map<Character, Integer> score = new HashMap<>();
	
	public WordScorer() {
		addPoints(new char[] { 'e', 'a', 'i', 'o', 'n', 'r', 't', 'l', 's', 'u' }, 1);
		addPoints(new char[] { 'd', 'g' }, 2);
		addPoints(new char[] { 'b', 'c', 'm', 'p' }, 3);
		addPoints(new char[] { 'f', 'h', 'v', 'w', 'y' }, 4);
		addPoints(new char[] { 'k' }, 5);
		addPoints(new char[] { 'j', 'x' }, 8);
		addPoints(new char[] { 'q', 'z' }, 10);
	}

	private void addPoints(char[] characters, int points) {
		for (Character chr : characters) {
			score.put(chr, points);
		}
	}

	public int scoreWord(String word) {
		int out = 0;
		for (Character chr : word.toCharArray()) {
			out += score.get(chr);
		}
		return out;
	}
	
}

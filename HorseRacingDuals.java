/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * HorseRacingDuals.java, Oct 6, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author trung.tran 
 * The Goal
 * 
 *         Casablanca’s hippodrome is organizing a new type of horse racing:
 *         duals. During a dual, only two horses will participate in the race.
 *         In order for the race to be interesting, it is necessary to try to
 *         select two horses with similar strength.
 * 
 *         Write a program which, using a given number of strengths, identifies
 *         the two closest strengths and shows their difference with an integer
 *         (≥ 0).
 */
public class HorseRacingDuals {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		List<Integer> pi = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			pi.add(in.nextInt());
		}
		Collections.sort(pi);
		List<Integer> sub = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			sub.add(pi.get(i) - pi.get(i - 1));
		}
		Collections.sort(sub);
		System.out.println(sub.get(0));
		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");

		// System.out.println("answer");
	}
}

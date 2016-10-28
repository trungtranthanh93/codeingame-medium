/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * TheGift.java, Oct 13, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class TheGift {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int C = in.nextInt();
		List<Integer> B = new ArrayList<Integer>();
		int total = 0;
		for (int i = 0; i < N; i++) {
			B.add(in.nextInt());
			total += B.get(i);
		}
		Collections.sort(B);
		// System.out.println(total);
		if (total < C) {
			System.out.println("IMPOSSIBLE");
		} else {
			int count = N;
			while (count > 0) {
				int best = B.get(0);
				if (best > C / count) {
					best = C / count;
					System.out.println(best);
				} else {
					System.out.println(best);
				}
				C = C - best;
				B.remove(0);
				count--;
			}

		}

		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");

		in.close();
	}

}

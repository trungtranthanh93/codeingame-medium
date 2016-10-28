/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * ShadowsOfTheKnight.java, Oct 14, 2016,  trung.tran
 */
package tests;

import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class ShadowsOfTheKnight {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int W = in.nextInt(); // width of the building.
		int H = in.nextInt(); // height of the building.
		int N = in.nextInt(); // maximum number of turns before game over.
		int X0 = in.nextInt();
		int Y0 = in.nextInt();
		int minW = 0;
		int minH = 0;
		// game loop
		while (true) {
			String bombDir = in.next(); // the direction of the bombs from
										// batman's current location (U, UR, R,
										// DR, D, DL, L or UL)
			if (bombDir.indexOf("U") > 0) {
				H = Y0;
				Y0 = (H + minH) / 2;
			}
			if (bombDir.indexOf("R") > 0) {
				minW = X0;
				X0 = (W + X0) / 2;
			}
			if (bombDir.indexOf("D") > 0) {
				minH = Y0;
				Y0 = (H + Y0) / 2;
			}
			if (bombDir.indexOf("L") > 0) {
				W = X0;
				X0 = (W + minW) / 2;
			}
			System.out.println(X0 + " " + Y0);
		}

	}

}

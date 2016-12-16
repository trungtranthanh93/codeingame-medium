package tests;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StreamInJava8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < a.length; j++) {
				if (j == 0) {
					int h = a[n - 1];
					a[n - 1] = a[j];
					a[j] = h;
				} else {
					a[j] = a[j - 1];
				}
			}
		}
		Arrays.stream(a).forEach(System.out::print);

	}
}

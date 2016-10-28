/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * StockExchangeLosses.java, Oct 7, 2016,  trung.tran
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
public class StockExchangeLosses {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long v[] = new long[n];
		for (int i = 0; i < n; i++) {
			v[i] = in.nextInt();
		}
		long p[] = new long[n - 1];
		List<Long> m = new ArrayList<Long>();
		long count = 0;
		int k = 0;
		for (int i = 0; i < n - 1; i++) {
			p[i] = v[i] - v[i + 1];
		}
		// Arrays.sort(p);
		for (long i : p) {
			if (i > 0 || i - count > 0) {
				count = count - i;
				m.add(count);
			} else {
				if (count < 0) {
					m.add(count);
					k++;
				}
				count = 0;
			}
		}
		Collections.sort(m);
		if (!m.isEmpty()) {
			System.out.println(m.get(0));
		} else {
			System.out.println(count);
		}
		
		 
		 
		// Write an action using System.out.prlongln()
		// To debug: System.err.prlongln("Debug messages...");
		// System.out.prlongln(p);

		/* Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int max=0; 
	        int answer = 0;
	        for (int i = 0; i < n; i++) {
	            int v = in.nextInt();
	           if(v>max){
	        	   max = v;
	           }else{
	        	   if(answer < max-v){
	        		   answer =  v-max;
	        	   }
	           }
	        }
	        System.out.println(answer);

        */

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

	}
}

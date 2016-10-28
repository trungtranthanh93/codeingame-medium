/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * ConwaySequence.java, Oct 13, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class ConwaySequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int L = in.nextInt();
		List<Integer> list = new ArrayList<>();
		String result = "";
		list.add(R);
		while (L > 1) {
			List<Integer> list2 = list;
			List<Integer> list1 = new ArrayList<>();
			while (list2.size() > 0) {
				int count = 1;
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i) == list.get(i + 1)) {
						count++;
					} else {
						break;
					}
				}
				list1.add(count);
				list1.add(list.get(0));
				for (int i = 0; i < count; i++) {
					list2.remove(0);
				}
			}
			list = list1;
			L--;
		}
		for (int i : list) {
			result = result.concat(i + " ");
		}
		System.out.println(result.trim());
		// System.out.println("answer");
	}
}

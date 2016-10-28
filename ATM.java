/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * ATM.java, Oct 20, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class ATM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int money = in.nextInt();
			int c = in.nextInt();
			Map<Integer, Integer> map = caculateMinNotesMoney(money, c);
			int totalNotes = 0;
			int numbers = 1;
			List<Integer> notes = new ArrayList<>();
			List<Integer> numbersOfWay = new ArrayList<>();
			map.forEach((k, v) -> {
				notes.add(v);
				String stringKey = Integer.toString(k);
				if (stringKey.charAt(0) == '1') {
					int k5 = k * 5;
					Integer v1 = map.get(k5);
					int min = 1;
					if (v1 != null) {
						min += Math.min(v, v1);
					}
					int k3 = k * 3;
					Integer v3 = map.get(k3);
					if (v3 != null) {
						min += Math.min(v, v3);
					}
					numbersOfWay.add(min);
				}

			});
			totalNotes = notes.stream().reduce(0, Integer::sum);
			numbers = numbersOfWay.stream().reduce(1, (a, b) -> a * b);
			System.out.println(totalNotes + " " + numbers);
		}

		in.close();
	}

	static Map<Integer, Integer> caculateMinNotesMoney(int money, int c) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> typeMoney = new ArrayList<>();
		while (c >= 0) {
			typeMoney.add((int) (5000 * Math.pow(10, c)));
			typeMoney.add((int) (3000 * Math.pow(10, c)));
			typeMoney.add((int) (2000 * Math.pow(10, c)));
			typeMoney.add((int) (1000 * Math.pow(10, c)));
			c--;
		}
		while (money > 0) {
			if (money >= typeMoney.get(0)) {
				int count = money / typeMoney.get(0);
				money = money - count * typeMoney.get(0);
				map.put(typeMoney.get(0), count);
			}
			typeMoney.remove(0);
		}
		return map;
	}
}

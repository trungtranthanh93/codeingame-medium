/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * TeadsSponsoredContest.java, Oct 17, 2016,  trung.tran
 */
package tests;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author trung.tran
 *
 */
public class TeadsSponsoredContest {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // the number of adjacency relations
		int min = n;
		Map<Integer, List<Integer>> map1 = new TreeMap<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int xi = in.nextInt(); // the ID of a person which is adjacent to yi
			int yi = in.nextInt(); // the ID of a person which is adjacent to xi
			List<Integer> list = new LinkedList<>();
			List<Integer> list2 = new LinkedList<>();
			if (map1.get(xi) != null) {
				list = map1.get(xi);
			}
			list.add(yi);
			map1.put(xi, list);
			if (map1.get(yi) != null) {
				list2 = map1.get(yi);
			}
			list2.add(xi);
			map1.put(yi, list2);
		}
		System.out.println(map1);
		// System.out.println(map1.size());
		while (map1.size() != 1) {
			Map<Integer, List<Integer>> map2 = new TreeMap<>();
			map2.putAll(map1);
			// System.out.println(map2);
			Set<Integer> set = map1.keySet();
			Iterator<Integer> iterator = set.iterator();
			while (iterator.hasNext()) {
				Integer i = (Integer) iterator.next();
				if (map1.get(i).size() == 1) {
					List<Integer> ls = map1.get(i);
					List<Integer> ls1 = new LinkedList<>();
					List<Integer> ls2 = map2.get(ls.get(0));
					if (ls2 == null) {
						break;
					}
					ls1.addAll(ls2);
					ls1.remove(i);
					map2.put(ls.get(0), ls1);
					map2.remove(i);
				}
			}
			map1 = map2;
			count++;
		}
		System.out.println(count);
		in.close();
	}

	static boolean isKey(Integer key, Set<Integer> set) {
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			if (integer == key) {
				return true;
			}

		}
		return false;
	}

	static List<Integer> removeNotKey(Set<Integer> key, List<Integer> value) {
		List<Integer> result = new LinkedList<>();
		result.addAll(value);
		for (Integer i : value) {
			if (!isKey(i, key)) {
				result.remove(i);
			}
		}
		return result;
	}

	static List<Integer> removeNotRoot(List<Integer> key, List<Integer> value) {
		List<Integer> result = new LinkedList<>();
		result.addAll(key);
		for (Integer i : key) {
			if (!isElement(i, value)) {
				result.remove(i);
			}
		}
		return result;

	}

	static boolean isElement(int key, List<Integer> value) {
		for (Integer integer : value) {
			if (key == integer)
				return true;
		}
		return false;
	}
}

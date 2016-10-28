package tests;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Teads {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // the number of adjacency relations
		TreeMap<Integer, TreeSet> relations = new TreeMap<>();
		int min = n;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int xi = in.nextInt(); // the ID of a person which is adjacent to yi
			int yi = in.nextInt(); // the ID of a person which is adjacent to xi
			TreeSet treeSet1 = new TreeSet<>();
			TreeSet treeSet2 = new TreeSet<>();
			// treeSet.add(yi);
			if (relations.get(xi) == null) {
				treeSet1.add(yi);
				relations.put(xi, treeSet1);
			} else {
				treeSet1.add(yi);
				treeSet1.addAll(relations.get(xi));
				relations.put(xi, treeSet1);
			}
			if (relations.get(yi) == null) {
				treeSet2.add(xi);
				relations.put(yi, treeSet2);
			} else {
				treeSet2.add(xi);
				treeSet2.addAll(relations.get(yi));
				relations.put(yi, treeSet2);
			}

		}
		Set keyRelations = getKey(relations);
		Object[] key = keyRelations.toArray();
		for (Object object : key) {
			int amount = findAmountKey(object, relations);
			if (amount < min) {
				min = amount;
			}
		}
		System.out.println(min);

	}

	/*
	 * static int findAmount(Object object, TreeMap treeMap) { int amount = 0;
	 * for(object) return amount; }
	 */

	static Set getKey(TreeMap treeMap) {
		return treeMap.keySet();
	}

	static Set getAllValue(TreeMap treeMap) {
		Set value = new TreeSet<>();
		Set key = getKey(treeMap);
		value.addAll(key);
		Object[] arrayAllKey = key.toArray();
		for (Object object : arrayAllKey) {
			value.addAll(getSetValue(object, treeMap));
		}
		return value;
	}

	static Set getValue(Object key, TreeMap treeMap) {
		Set value = new TreeSet<>();
		value.add(key);
		value.addAll(getSetValue(key, treeMap));
		return value;

	}

	static Set getSetValue(Object key, TreeMap treeMap) {
		// Set value = new TreeSet<>();
		return (Set) treeMap.get(key);
	}

	static int findAmountKey(Object key, TreeMap treeMap) {
		int count = 0;
		Set allValue = getAllValue(treeMap);
		Set valueKey = new TreeSet<>();
		// Set setObject = new TreeSet<>();
		valueKey.add(key);
		Object[] objs = valueKey.toArray();
		while (!allValue.equals(valueKey)) {
			for (Object object : objs) {
				valueKey.addAll(getValue(object, treeMap));
			}
			objs = valueKey.toArray();
			count++;
		}
		return count;
	}
}
/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * QuickSort.java, Oct 25, 2016,  trung.tran
 */
package tests;

import java.util.Arrays;

/**
 * @author trung.tran
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] x2 = new int[] { 1,2,3,4,1,1,4,1 };
		quickSort(x2);
		System.out.println(Arrays.toString(x2));
	}

	/**
	 * @param x2
	 * @param i
	 * @param j
	 */
	private static void quickSort(int[] x, int left, int right) {
		int index = partion(x, left, right);
		if (left < index - 1) {
			quickSort(x, left, index - 1);
		}
		if (right > index) {
			quickSort(x, index, right);
		}
	}

	/**
	 * @param x
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partion(int[] x, int left, int right) {
		int i = left;
		int j = right;
		int pivote = x[(left + right) / 2];
		while (i <= j) {
			while (x[i] < pivote) {
				i++;
			}
			while (x[j] > pivote) {
				j--;
			}
			if (i <= j) {
				int tmp = x[i];
				x[i] = x[j];
				x[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	private static void quickSort(int[] x) {
		quickSort(x, 0, x.length - 1);
	}

}

/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * HoanVi.java, Oct 26, 2016,  trung.tran
 */
package tests;

/**
 * @author trung.tran
 *
 */
public class HoanVi {
	static void sinhHoanVi(int[] a, int i) {
		if (i == 1) {
			System.out.print(a[0]);
		} else {
			for (int j = 1; j <= (i-1); j++) {
				swap(a, (i-1), j);
				sinhHoanVi(a, i - 2);
				swap(a, j, (i-1));
			}
		}
	}

	/**
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;

	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2};
		sinhHoanVi(a, a.length);
	}
}
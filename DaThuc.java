/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * DaThuc.java, Oct 13, 2016,  trung.tran
 */
package tests;



/**
 * @author trung.tran
 *
 */
public class DaThuc {
	public static void main(String[] args) {
		/*int n = 5376042;
		int k = n;
		int t = n;
		int m = 20;
		int v = n;
		int count = 1;
		while (t >= m) {
			t = t / m;
			count++;
		}
		int[] result = new int[count];

		while (v > m) {
			int count1 = 0;
			while (k >= m) {
				k = k / m;
				count1++;
			}
			result[count1 - 1] = k;
			int h = (int) (k * Math.pow(m, count1));
			k = v - h;
			v = k;
			count1 = 0;
		}
		result[0] = v;
		for (int i : result) {
			System.out.println(i);
		}*/
		int[] x = {12,0,5};
		//System.out.println(convertToNumber(x));
		//System.out.println(16+20*20*20);
		// System.out.println(h);
		// System.out.println(n - h);
		// System.out.println(Math.pow(20, 4));
		// System.out.println(count);
		int a= 5+17*20+10*20*20+20*20*20;
		int b= 12+10*20+12*400+18*20*20*20+4*20*20*20*20;
		//System.out.println(a*b);
		//System.out.println(Math.pow(2, 63)-1150418548);
		//int k = 8+7*20+6*400+2*20*20*20+10*20*20*20*20+19*20*20*20*20*20+17*20*20*20*20*20*20;
		//System.out.println(a*b-k);
		int k[] = divideNumberToListInt(a*b,20);
		int total=0;
		int[] k1 = {0,17,2,4,17,3,12,7}; 
		for(int i = 0;i<k1.length;i++){
			total +=  k1[i]*Math.pow(20, i);
		}
		System.out.println((long)8345*788812);
		System.out.println((double)(8345*788812));
		//System.out.println(total);

	}
	static int convertToNumber(int[] arrayNumber1) {
		int output = 0;
		for (int i = arrayNumber1.length - 1; i >= 0; i--) {
			output += arrayNumber1[i] * Math.pow(20, i);
		}
		return output;
	}
	static int[] divideNumberToListInt(int n, int m) {
		int k = n;
		int t = n;
		int v = n;
		int count = 1;
		while (t >= m) {
			t = t / m;
			count++;
		}
		int[] result = new int[count];

		while (v > m) {
			int count1 = 0;
			while (k >= m) {
				k = k / m;
				count1++;
			}
			result[count1] = k;
			int h = (int) (k * Math.pow(m, count1));
			k = v - h;
			v = k;
			count1 = 0;
		}
		result[0] = v;
		return result;
	}

}

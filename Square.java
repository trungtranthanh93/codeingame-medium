/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * Square.java, Oct 12, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class Square {
	// public static void main(String args[]) {
	// Scanner in = new Scanner(System.in);
	// String code = in.next();
	// // Write an action using System.out.println()
	// // To debug: System.err.println("Debug messages...");
	// for(int i=0;i<code.length()-1;i=i+3){
	// String x =code.substring(i,i+3);
	// //System.out.println(x);
	// if(x.charAt(0)=='0'){
	// x=x.substring(1,x.length());
	// }
	// //System.out.println(x);
	// char y = (char)(Integer.parseInt(x));
	// System.out.print(y);
	// }
	// }
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String x = in.next();
		String result = "";
		for(int i=0;i<x.length();i++){
			result +=x.charAt(i);
			int count =0;
			for(int j=i;j>=0;j--){
				if(x.charAt(i)==x.charAt(j)){
				
					if(count>0){
					result+=x.charAt(j);
					}
					count++;
				}
			}
		}
		System.out.println(result);
	}
}

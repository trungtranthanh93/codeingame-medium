/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * Spoon.java, Oct 11, 2016,  trung.tran
 */
package tests;

import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class Spoon {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int width = in.nextInt(); // the number of cells on the X axis
		int height = in.nextInt(); // the number of cells on the Y axis
		in.nextLine();
		String[] line = new String[height];
		for (int i = 0; i < height; i++) {
			line[i] = in.next(); // width characters, each either 0 or .
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (line[i].charAt(j) == '0') {
					System.out.print(j + " " + i + " ");
					int k = j;
					int h  = i;
					while(k+1<width){
						if(line[i].charAt(k+1) == '0'){
							System.out.print((k+1) +" "+ i + " ");
							break;
						}else{
							k++;
						}
					}
					if(k+1==width){
						System.out.print("-1 -1 ");
					}
					while(h+1<height){
						if(line[h+1].charAt(j) == '0'){
							System.out.print((j) +" "+ (h+1));
							break;
						}else{
							h++;
						}
					}
					if (h + 1==height){
						System.out.print("-1 -1");
					}
					System.out.println();
				}
			}
		}
		in.close();
	}
}

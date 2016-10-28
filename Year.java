/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * year.java, Oct 5, 2016,  trung.tran
 */
package tests;

import java.util.Scanner;

/**
 * @author trung.tran
 *
 */
public class Year {
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        for (int i = 0; i < H; i++) {
			String ROW = in.nextLine();
			for (int j = 0; j < T.length(); j++) {
				int decNumber = (int) T.charAt(j);
				int numberChar = 0;
				if (decNumber > 64 && decNumber < 91 || decNumber > 96 && decNumber < 123) {
					if (decNumber > 64 && decNumber < 91) {
						numberChar = (decNumber - 65)*L;
						System.out.print(ROW.substring(numberChar , numberChar +L));

					} else {
						numberChar = (decNumber - 97)*L;
						System.out.print(ROW.substring(numberChar, numberChar +L));

					}
				} else {
					System.out.print(ROW.substring(ROW.length() - L, ROW.length() - 1)+" ");
				}
			}
			System.out.println();
		}

		//get data
				//Scanner in = new Scanner(System.in);
				//char[] message = in.nextLine().toCharArray();
				char[] message = {(char)'C'};
				//convert data into binary format
				StringBuilder binary = new StringBuilder();
				for(char c : message) {
					String res = Integer.toBinaryString(c);
					
					//for non-letters
					while(res.length() < 7) res = '0' + res;
					
					binary.append(res);
				}
				
				//convert to unary and print to console
				int i = 0;
				char currentChar;
				while(i < binary.length()) {
					if(binary.charAt(i) == '0') {
						System.out.print("00 ");
						currentChar = '0';
					}
					else {
						System.out.print("0 ");
						currentChar = '1';
					}
					while(binary.charAt(i) == currentChar) {
						System.out.print("0");
						i++;
						if(i >= binary.length()) break;
					}
					if(i < binary.length()) System.out.print(" ");
				}
				in.close();
			
        
	}
}

/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * MIMEType.java, Oct 6, 2016,  trung.tran
 */
package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author trung.tran MIME types are used in numerous internet protocols to
 *         associate a media type (html, image, video ...) with the content
 *         sent. The MIME type is generally inferred from the extension of the
 *         file to be sent.
 * 
 *         You have to write a program that makes it possible to detect the MIME
 *         type of a file based on its name. Rules You are provided with a table
 *         which associates MIME types to file extensions. You are also given a
 *         list of names of files to be transferred and for each one of these
 *         files, you must find the MIME type to be used.
 * 
 *         The extension of a file is defined as the substring which follows the
 *         last occurrence, if any, of the dot character within the file name.
 *         If the extension for a given file can be found in the association
 *         table (case insensitive, e.g. TXT is treated the same way as txt),
 *         then print the corresponding MIME type. If it is not possible to find
 *         the MIME type corresponding to a file, or if the file doesn’t have an
 *         extension, print UNKNOWN.
 */
public class MIMEType {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // Number of elements which make up the
								// association table.
		int Q = in.nextInt(); // Number Q of file names to be analyzed.
		List<String> EXT = new ArrayList<String>();
		List<String> MT = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			EXT.add(in.next().toUpperCase()); // file extension
			MT.add(in.next()); // MIME type.
		}
		in.nextLine();
		for (int i = 0; i < Q; i++) {
			String FNAME = in.nextLine(); // One file name per line.
			String[] array = FNAME.split("[.]");
			if (array.length <= 1 || FNAME.charAt(FNAME.length() - 1) == '.') {
				System.out.println("UNKNOWN");
			} else {

				String mime = array[array.length - 1].toUpperCase();
				int count = 0;
				for (int j = 0; j < EXT.size(); j++) {
					if (mime.equals(EXT.get(j))) {
						System.out.println(MT.get(j));
						count++;
					}
				}
				if (count == 0) {
					System.out.println("UNKNOWN");
				}
			}
		}
	}

}

/**
 * Copyright(C) 2016 Luvina Software Company
 *
 * StreamInJava8.java, Oct 25, 2016,  trung.tran
 */
package tests;

import java.util.stream.Stream;

/**
 * @author trung.tran
 *
 */
public class StreamInJava8 {
	public static void main(String[] args) {
		/*Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {

			System.out.println("filter: " + s);
			return s.startsWith("d");
		}).map(s -> {
			System.out.println("map " + s);
			return s;
		}).sorted().mapToInt(x -> x.charAt(1)).forEach(System.out::println);
		;*/
		Stream.of("d2", "c", "b1", "b3", "a1")
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	   /*.filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })*/
	    .forEach(s -> System.out.println("forEach: " + s));
	}

}

package com.cts.returnship.jff.ui;

import java.util.Arrays;

public class StreamsAndExceptions {

	public static void main(String[] args) {

		Arrays.stream(new int[] {-3,-2,-1,0,1,2,3})
		.map(n -> 25/n)
		.forEach(System.out::println);
	}

}

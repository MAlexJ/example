package com.malex.lecture_25_Java_8.sample_01;

import java.util.stream.LongStream;

public class Sample_Main {

	public static void main(String[] args) {

		long count = LongStream.range(1, 100).count();
		System.out.println(count);
	}

}

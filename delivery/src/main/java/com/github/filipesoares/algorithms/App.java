package com.github.filipesoares.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class App {

    private App() {
    }

	public static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {

		area.forEach(line -> {
			line.forEach(System.out::print);
		});
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int numRows = 3;
		int numColumns = 3;
		List<List<Integer>> area = new ArrayList<>();
		area.add(Arrays.asList(1,0,0));
		area.add(Arrays.asList(1,0,0));
		area.add(Arrays.asList(1,9,1));
		
		int result = minimumDistance(numRows, numColumns, area);
    }
    
}

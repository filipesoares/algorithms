package com.github.filipesoares.algorithms;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.filipesoares.algorithms.App;

public class AppTest {
	
	@Test
	public void minimumDistanceTest_1() {

		int numRows = 3;
		int numColumns = 3;
		List<List<Integer>> area = new ArrayList<>();
		area.add(Arrays.asList(1,0,0));
		area.add(Arrays.asList(1,0,0));
		area.add(Arrays.asList(1,9,1));
		
		int result = App.minimumDistance(numRows, numColumns, area);

		assertThat(result, equalTo(3));
	}

	@Test
	public void minimumDistanceTest_2() {

		int numRows = 5;
		int numColumns = 4;
		List<List<Integer>> area = new ArrayList<>();
		area.add(Arrays.asList(1,1,1,1));
		area.add(Arrays.asList(0,1,1,1));
		area.add(Arrays.asList(0,1,0,1));
		area.add(Arrays.asList(1,1,9,1));
		area.add(Arrays.asList(0,0,1,1));
		
		int result = App.minimumDistance(numRows, numColumns, area);

		assertThat(result, equalTo(5));
	}

}

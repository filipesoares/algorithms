package com.github.filipesoares.algorithms;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.filipesoares.algorithms.App;

public class AppTest {
	
	@Test
	public void sortTest_1() {
		
		List<String> boxes = new ArrayList<>();
		boxes.add("ykc 82 01");
		boxes.add("eo first qpx");
		boxes.add("09z cat hamster");
		boxes.add("06f 12 25 6");
		boxes.add("az0 first qpx");
		boxes.add("236 cat dog rabbit snake");
		
		List<String> result = App.sortBoxes(boxes.size(), boxes);
		
		List<String> expected = new ArrayList<>();
		expected.add("236 cat dog rabbit snake");
		expected.add("09z cat hamster");
		expected.add("az0 first qpx");
		expected.add("eo first qpx");
		expected.add("ykc 82 01");
		expected.add("06f 12 25 6");
		
		assertThat(result, equalTo(expected));
	}
	
	@Test
	public void sortTest_2() {
		
		List<String> boxes = new ArrayList<>();
		boxes.add("mi2 jog mid pet");
		boxes.add("wz3 34 54 398");
		boxes.add("a1 alps cow bar");
		boxes.add("x4 45 21 7");
		
		List<String> result = App.sortBoxes(boxes.size(), boxes);
		
		List<String> expected = new ArrayList<>();
		expected.add("a1 alps cow bar");
		expected.add("mi2 jog mid pet");
		expected.add("wz3 34 54 398");
		expected.add("x4 45 21 7");
		
		assertThat(result, equalTo(expected));
	}
	
	@Test
	public void sortTest_3() {
		
		List<String> boxes = new ArrayList<>();
		boxes.add("t2 13 121 98");
		boxes.add("r1 box ape bit");
		boxes.add("b4 xi me nu");
		boxes.add("br8 eat nim did");
		boxes.add("w1 has uni gry");
		boxes.add("f3 52 54 31");
		
		List<String> result = App.sortBoxes(boxes.size(), boxes);
		
		List<String> expected = new ArrayList<>();
		expected.add("r1 box ape bit");
		expected.add("br8 eat nim did");
		expected.add("w1 has uni gry");
		expected.add("b4 xi me nu");
		expected.add("t2 13 121 98");
		expected.add("f3 52 54 31");
		
		assertThat(result, equalTo(expected));
	}

}

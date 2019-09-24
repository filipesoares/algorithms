package com.github.filipesoares.algorithms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.filipesoares.algorithms.App;

public class PrimeNumbersTest {

	@Test
	public void given(){
		assertThat(PrimeNumbers.fetch(2, 23), equalTo(23));
	}

}

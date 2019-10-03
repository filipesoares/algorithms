package com.github.filipesoares.algorithms.array.leftrotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class Solution {
	
	static int[] rotLeft(int[] a, int d) {
    	
		int[] array = new int[a.length];
		
    	for (int i = 0; i < a.length; i++) {    	
    		if (i==d)
    			array[0] = a[i];
    		else if((i-d)<0)
    			array[(a.length+(i-d))] = a[i];
    		else
    			array[i-d] = a[i];
		}
    	return array;
    }

    public static void main(String[] args) throws IOException {
        
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] params = reader.readLine().split(" ");
        
        int n = Integer.parseInt(params[0]);
        int d = Integer.parseInt(params[1]);
        
        String[] aItems = reader.readLine().split(" ");
        
        reader.close();
        
        rotLeft(Arrays
				.asList(aItems)
				.stream()
				.mapToInt(Integer::parseInt).toArray(), d);
        
        bufferedWriter.flush();
        bufferedWriter.close();
        
    }
}
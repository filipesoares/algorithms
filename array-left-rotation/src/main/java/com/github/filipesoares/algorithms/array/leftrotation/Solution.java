package com.github.filipesoares.algorithms.array.leftrotation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    	
    	do {
    		
    		int[] array = new int[a.length];
    		
    		for (int j = 0; j < a.length; j++) {
    			if (j==0)
    				array[(a.length-1)] = a[j];
    			
    			else
    				array[j-1] = a[j];
			}
    		 
    		d--;
    		a = array;
    		
    		
		} while (d>0);
    	
    	return a;

    }

    public static void main(String[] args) throws IOException {
        
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] params = reader.readLine().split(" ");
        
        int n = Integer.parseInt(params[0]);
        int d = Integer.parseInt(params[1]);
        
        String[] aItems = reader.readLine().split(" ");
        
        int[] result = rotLeft(Arrays
				.asList(aItems)
				.stream()
				.mapToInt(Integer::parseInt).toArray(), d);
        
        for (int i = 0; i < result.length; i++) {
        	bufferedWriter.write(String.valueOf(result[i]) + (i!=(result.length-1) ?  " ": ""));
		}

        bufferedWriter.flush();
        bufferedWriter.close();
        
    }
}
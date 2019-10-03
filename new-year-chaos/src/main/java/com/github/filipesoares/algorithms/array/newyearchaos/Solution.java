package com.github.filipesoares.algorithms.array.newyearchaos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {


    }

    public static void main(String[] args) throws IOException {
        
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < t; i++) {

        	int n = Integer.parseInt(reader.readLine());
			
			String[] itens = reader.readLine().split(" ");
			
			minimumBribes(Arrays
				.asList(itens)
				.stream()
				.mapToInt(Integer::parseInt).toArray());
			
		}
        
        reader.close();
        
        bufferedWriter.flush();
        bufferedWriter.close();
        
    }


}

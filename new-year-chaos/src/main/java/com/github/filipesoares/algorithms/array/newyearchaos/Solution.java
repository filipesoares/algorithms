package com.github.filipesoares.algorithms.array.newyearchaos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static void minimumBribes(int[] q) {

        int ans = 0;
        String result = "";
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                result = "Too chaotic";
                ans = 0;
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }

        result = ( (ans > 0) ? String.valueOf(ans) : result );

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] tests = reader.readLine().split(" ");
        int t = Integer.parseInt(tests[0]);
        if ( (1 <= t) && (10 >= t) ){
            for (int i = 1; i <= t; i++) {
                final String[] itens = reader.readLine().split(" ");
                int n = Integer.parseInt(itens[0]);
                if ( n >= 1 && (n <= Math.pow(10,5) ) ){
                    int[] q = new int[n];
                    final String[] numbers = reader.readLine().split(" ");

                    for (int j = 0; j < n; j++) {
                        q[j] = Integer.parseInt(numbers[j]);
                    }
                    minimumBribes(q);
                }
            }
        }
        reader.close();
        
    }


}

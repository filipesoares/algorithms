package com.github.filipesoares.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class PrimeNumbers {

	static Integer fetch(Integer start, Integer end) {

        List<Integer> numbers = new ArrayList<>();

        if (start<=1 || end<=1 || start>Integer.MAX_VALUE || end>Integer.MAX_VALUE)
            throw new IllegalArgumentException("Os parâmetros devem ser maiores que 1 e menores que " + Integer.MAX_VALUE);
        
        for (int i = start; i <= end; i++)
            numbers.add(i);
            
        Optional<Integer> max = numbers
                                    .stream()
                                    .filter(n->isPrime(n))
                                    .max(Integer::compare);    
        
        return max.isPresent() ? max.get() : 0;
	}

	static boolean isPrime(int n) 
    { 
        if (n <= 1) 
            return false; 
       
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
       
        return true; 
    } 	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        br.close();
        
        writer.write(fetch(start, end).toString());
        writer.flush();
        writer.close();
    }
    
}

package com.github.filipesoares.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Solution {

    public static void printAllPaths(String s, String d, long v) 
	{ 
		boolean[] isVisited = new boolean[v]; 
		ArrayList<String> pathList = new ArrayList<>(); 
		
		//add source to path[] 
		pathList.add(s); 
		
		//Call recursive utility 
		printAllPathsUtil(s, d, isVisited, pathList); 
    }
    
    private static void printAllPathsUtil(String u, String d, 
									boolean[] isVisited, 
							List<String> localPathList) { 
		
		// Mark the current node 
		isVisited[u] = true; 
		
		if (u.equals(d)) 
		{ 
			System.out.println(localPathList); 
			// if match found then no need to traverse more till depth 
			isVisited[u]= false; 
			return ; 
		} 
		
		// Recur for all the vertices 
		// adjacent to current vertex 
		for (Integer i : adjList[u]) 
		{ 
			if (!isVisited[i]) 
			{ 
				// store current node 
				// in path[] 
				localPathList.add(i); 
				printAllPathsUtil(i, d, isVisited, localPathList); 
				
				// remove current node 
				// in path[] 
				localPathList.remove(i); 
			} 
		} 
		
		// Mark the current node 
		isVisited[u] = false; 
	} 

	public static void main(String[] args) throws Exception {

        final String graph = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
        String[] split = graph.split(",");

        List<String> graphList = Arrays.asList(split)
                .stream()
                .map(s -> s.substring(0, 2))
                .collect(Collectors.toList());

        long vertices = graphList
                            .stream()
                            .map(s-> s.substring(0, 1))
                            .distinct().count();

        printAllPaths("A", "C", vertices);

    }
    
}

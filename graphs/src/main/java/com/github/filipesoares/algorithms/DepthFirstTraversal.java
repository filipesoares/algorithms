package com.github.filipesoares.algorithms;

//JAVA program to print all 
//paths from a source to 
//destination. 
import java.util.ArrayList; 
import java.util.List; 

//A directed graph using 
//adjacency list representation 
public class DepthFirstTraversal { 

	// No. of vertices in graph 
	private int v; 
	
	// adjacency list 
	private ArrayList<Integer>[] adjList; 
	
	//Constructor 
	public DepthFirstTraversal(int vertices){ 
		
		//initialise vertex count 
		this.v = vertices; 
		
		// initialise adjacency list 
		initAdjList(); 
	} 
	
	// utility method to initialise 
	// adjacency list 
	@SuppressWarnings("unchecked") 
	private void initAdjList() 
	{ 
		adjList = new ArrayList[v]; 
		
		for(int i = 0; i < v; i++) 
		{ 
			adjList[i] = new ArrayList<>(); 
		} 
	} 
	
	// add edge from u to v 
	public void addEdge(int u, int v) 
	{ 
		// Add v to u's list. 
		adjList[u].add(v); 
	} 
	
	// Prints all paths from 
	// 's' to 'd' 
	public void printAllPaths(int s, int d) 
	{ 
		boolean[] isVisited = new boolean[v]; 
		ArrayList<Integer> pathList = new ArrayList<>(); 
		
		//add source to path[] 
		pathList.add(s); 
		
		//Call recursive utility 
		printAllPathsUtil(s, d, isVisited, pathList); 
	} 

	// A recursive function to print 
	// all paths from 'u' to 'd'. 
	// isVisited[] keeps track of 
	// vertices in current path. 
	// localPathList<> stores actual 
	// vertices in the current path 
	private void printAllPathsUtil(Integer u, Integer d, 
									boolean[] isVisited, 
							List<Integer> localPathList) { 
		
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

	// Driver program 
	public static void main(String[] args) 
	{ 
		
		// AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
		// 0,1  1,2  2,3  3,2  3,4  0,3  2,4  4,1  0,4
		// 
		// A => 0
		// B => 1
		// C => 2
		// D => 3
		// E => 4
		
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge("A", "B"));
		edges.add(new Edge("B", "C"));
		edges.add(new Edge("C", "D"));
		edges.add(new Edge("D", "C"));
		edges.add(new Edge("D", "E"));
		edges.add(new Edge("A", "D"));
		edges.add(new Edge("C", "E"));
		edges.add(new Edge("E", "B"));
		edges.add(new Edge("A", "E"));
		
		// Create a sample graph 
		DepthFirstTraversal g = new DepthFirstTraversal(5); 
		g.addEdge(0,1); 
		g.addEdge(0,3); 
		g.addEdge(0,4); 
		g.addEdge(1,2); 
		g.addEdge(2,3); 
		g.addEdge(2,4);
		g.addEdge(3,2);
		g.addEdge(3,4);
		g.addEdge(4,1);
	
		// arbitrary source 
		int s = 0; 
	
		// arbitrary destination 
		int d = 2; 
	
		System.out.println("Following are all different paths from "+s+" to "+d); 
		g.printAllPaths(s, d); 

	}
}

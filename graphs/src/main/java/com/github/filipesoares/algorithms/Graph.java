package com.github.filipesoares.algorithms;

import java.util.List;

public class Graph {

    private Long id;
    private List<Edge> data;
    
    public Graph() {	
	}
    
    public Graph(List<Edge> data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Edge> getData() {
		return data;
	}

	public void setData(List<Edge> data) {
		this.data = data;
	}

}

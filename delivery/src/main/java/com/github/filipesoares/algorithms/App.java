package com.github.filipesoares.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author filipe.soares
 *         https://www.geeksforgeeks.org/move-matrix-elements-given-direction-add-elements-value/
 *         https://www.geeksforgeeks.org/find-number-of-islands/
 */
public final class App {

	private int rows = 0;
	private int columns = 0;
	private boolean founded = false;
	private int count = 0;

	public App() {}

	private boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < this.rows) && (col >= 0) && (col < this.columns) && (M[row][col] == 1 && !visited[row][col]);
	}

	private void dfs(int[][] matrix, int row, int column, boolean[][] visited) {
		
		System.out.println("(" + row + "," + column + ") " + matrix[row][column]);

		int[] edgesRow = { -1, 1, 0, 0 };
		int[] edgesCol = { 0, 0, -1, 1 };
		visited[row][column] = true;
		
		for (int i = 0; i < 4; i++) {
			if ( (row + edgesRow[i] >= 0) && (row + edgesRow[i] < rows) && (column + edgesCol[i] >= 0) 
					&& (column + edgesCol[i] < columns) 
					&& (matrix[row + edgesRow[i]][column + edgesCol[i]]==9) ) {
				founded = true;
				break;
			}
			if ( (i+1<4) && (row + edgesRow[i] >= 0) && (row + edgesRow[i] < rows) && (column + edgesCol[i+1] >= 0) && (column + edgesCol[i+1] < columns) 
					&& (matrix[row + edgesRow[i]][column + edgesCol[i+1]]==9) ) {
				founded = true;
				break;
			}
			if ( isSafe(matrix, row + edgesRow[i], column + edgesCol[i], visited) && founded==false) {
				dfs(matrix, row + edgesRow[i], column + edgesCol[i], visited);
			}
		}

		count++;
	}

	public int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {

		int[][] data = new int[numRows][numColumns];

		for (int i = 0; i < area.size(); i++) {
			List<Integer> line = area.get(i);
			for (int j = 0; j < line.size(); j++) {
				data[i][j] = line.get(j);
			}
		}

		boolean check[][] = new boolean[numRows][numColumns];
		rows = numRows;
		columns = numColumns;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				if (data[i][j] == 9) {
					break;
				}
				if (data[i][j] == 1 && !check[i][j] && founded==false) {
					dfs(data, i, j, check);
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws Exception {
		int numRows = 3;
		int numColumns = 3;
		List<List<Integer>> area = new ArrayList<>();
		area.add(Arrays.asList(1, 0, 0));
		area.add(Arrays.asList(1, 0, 0));
		area.add(Arrays.asList(1, 9, 1));

		// System.out.println(minimumDistance(numRows, numColumns, area));

		numRows = 5;
		numColumns = 4;
		area.clear();
		area.add(Arrays.asList(1, 1, 1, 1));
		area.add(Arrays.asList(0, 1, 1, 1));
		area.add(Arrays.asList(0, 1, 0, 1));
		area.add(Arrays.asList(1, 1, 9, 1));
		area.add(Arrays.asList(0, 0, 1, 1));
		
		App app = new App();

		// System.out.println(app.minimumDistance(numRows, numColumns, area));
	}

}

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

	static int rows = 0;
	static int columns = 0;

	private App() {
	}

	private static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < rows) && (col >= 0) && (col < columns) && (M[row][col] == 1 && !visited[row][col]);
	}

	private static boolean dfs(int[][] matrix, int row, int column, boolean[][] visited) {
		
		System.out.println("(" + row + "," + column + ") " + matrix[row][column]);

		int[] edgesRow = { -1, 1, 0, 0 };
		int[] edgesCol = { 0, 0, -1, 1 };
		visited[row][column] = true;
		boolean found = false;
		
		for (int i = 0; i < 4; i++) {
			if ( (row + edgesRow[i] >= 0) && (row + edgesRow[i] < rows) && (column + edgesCol[i] >= 0) && (column + edgesCol[i] < columns) && (matrix[row + edgesRow[i]][column + edgesCol[i]]==9) ) {
				System.out.println("Hit");
				found = true;
				break;
			}
			if ( isSafe(matrix, row + edgesRow[i], column + edgesCol[i], visited) ) {
				dfs(matrix, row + edgesRow[i], column + edgesCol[i], visited);
			}
		}
		return found;
	}

	public static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {

		int[][] data = new int[numRows][numColumns];

		for (int i = 0; i < area.size(); i++) {
			List<Integer> line = area.get(i);
			for (int j = 0; j < line.size(); j++) {
				data[i][j] = line.get(j);
			}
		}

		boolean check[][] = new boolean[numRows][numColumns];
		int count = 0;
		rows = numRows;
		columns = numColumns;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				if (data[i][j] == 9) {
					// System.out.println("(" + i + "," + j + ")");
					break;
				}
				if (data[i][j] == 1 && !check[i][j]) {
					if (dfs(data, i, j, check)) {
						i = numRows;
						break;
					} else {
						++count;
					}
				}
				// check[i][j] = true;
				// System.out.print(data[i][j]);

			}
		}

		// System.out.println(Arrays.deepToString(data));
		// System.out.println(count);

		return count;
	}

	public static void main(String[] args) throws Exception {
		int numRows = 3;
		int numColumns = 3;
		List<List<Integer>> area = new ArrayList<>();
		area.add(Arrays.asList(1, 0, 0));
		area.add(Arrays.asList(1, 0, 0));
		area.add(Arrays.asList(1, 9, 1));

		System.out.println(minimumDistance(numRows, numColumns, area));

		numRows = 5;
		numColumns = 4;
		area.clear();
		area.add(Arrays.asList(1, 1, 1, 1));
		area.add(Arrays.asList(0, 1, 1, 1));
		area.add(Arrays.asList(0, 1, 0, 1));
		area.add(Arrays.asList(1, 1, 9, 1));
		area.add(Arrays.asList(0, 0, 1, 1));

		System.out.println(minimumDistance(numRows, numColumns, area));
	}

}

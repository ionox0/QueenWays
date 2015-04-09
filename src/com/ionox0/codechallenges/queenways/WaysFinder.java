package com.ionox0.codechallenges.queenways;

public class WaysFinder {
	
	public static void main(String[] args) {
		int args0 = Integer.parseInt(args[0]);
		int args1 = Integer.parseInt(args[1]);
		int args2 = Integer.parseInt(args[2]);
		int[][] startGrid = new int[args0][args1];
		System.out.println("Grid size: " + startGrid.length);
		System.out.println("Start Queens: " + args2 + "\n");
		System.out.println(countWays(startGrid, args2) + " WAYS");
	}
	
	public static int countWays(int[][] grid, int queens) {
		System.out.println("\nqueensLeft: " + queens);
		printGrid(grid);
		int ways = 0;
		
		if (queens > 1) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid.length; j++) {
					System.out.println("i: " + i + " j: " + j + " space: " + grid[i][j]);
					if (grid[i][j] != 1) {
						System.out.println("empty space found");
						int[][] newGrid = new int[grid.length][grid.length];
						for (int l = 0; l < grid.length; l++) newGrid[l] = grid[l].clone();
						ways += countWays(closeSpaces(newGrid, i, j), queens - 1);
					}
				}
			}
		} else {
			return countSpacesLeft(grid);
		}
		return ways;
	}
	
	public static int[][] closeSpaces(int[][] grid, int row, int column) {
		// HORIZONTAL, VERTICAL:
		for (int k = 0; k < grid.length; k++) {
			grid[row][k] = 1;
			grid[k][column] = 1;
		}
		
		// DIAGONALS:
		// Down and to the right
		int tempRow = row + 1;
		int tempColumn = column + 1;
		while (tempRow < grid.length && tempColumn < grid.length) {
			grid[tempRow][tempColumn] = 1;
			tempRow++; tempColumn++;
		}
		// Up and to the left
		tempRow = row - 1;
		tempColumn = column - 1;
		while (tempRow >= 0 && tempColumn >= 0) {
			grid[tempRow][tempColumn] = 1;
			tempRow--; tempColumn--;
		}
		// Up and to the right
		tempRow = row - 1;
		tempColumn = column + 1;
		while (tempRow >= 0 && tempColumn < grid.length) {
			grid[tempRow][tempColumn] = 1;
			tempRow--; tempColumn++;
		}
		// Down and to the left
		tempRow = row + 1;
		tempColumn = column - 1;
		while (tempRow < grid.length && tempColumn >= 0) {
			grid[tempRow][tempColumn] = 1;
			tempRow++; tempColumn--;
		}
		
		// KNIGHT SPACES:
//		if (row+2 < grid.length && column+1 < grid.length) {
//			grid[row+2][column+1] = 1;
//		}
//		if (row+2 < grid.length && column-1 >= 0) {
//			grid[row+2][column-1] = 1;
//		}
//		if (row+1 < grid.length && column+2 < grid.length) {
//			grid[row+1][column+2] = 1;
//		}
//		if (row-1 >= 0 && column+2 < grid.length) {
//			grid[row-1][column+2] = 1;
//		}
//		if (row-2 >= 0 && column+1 < grid.length) {
//			grid[row-2][column+1] = 1;
//		}
//		if (row-2 >= 0 && column-1 >= 0) {
//			grid[row-2][column-1] = 1;
//		}
//		if (row-1 >= 0 && column-2 >= 0) {
//			grid[row-1][column-2] = 1;
//		}
//		if (row+1 < grid.length && column-2 >= 0) {
//			grid[row+1][column-2] = 1;
//		}
//		
		return grid;
	}
	
	public static int countSpacesLeft(int[][] grid) {
		int openSpaces = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 0) openSpaces++;
			}
		}
		System.out.println("COUNTSPACESLEFT: " + openSpaces + ", BOARD: ");
		printGrid(grid);
		return openSpaces;
	}
	
	public static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			} System.out.println();
		} System.out.println();
	}

}

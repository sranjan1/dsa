package com.sranjan.dsa.matrix;

public class MatrixOperations {

	public static void main(String... args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Matrix before rotation : ");
		printMatrix(matrix);
		antiRotate(matrix);
		System.out.println("Matrix after rotation : ");
		printMatrix(matrix);

	}

	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int first = 0, last = rows - 1; first < last; first++, last--) {
			int[] temp = matrix[first];
			matrix[first] = matrix[last];
			matrix[last] = temp;
		}

		for (int i = 0; i < rows; i++) {
			for (int j = i + 1; j < cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void antiRotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		//First swap last column with first then swap rows vs cols
		for(int first = 0, last = cols - 1; first < last; first++, last--) {
			for(int i= 0; i<rows; i++) {
				int temp = matrix[i][first];
				matrix[i][first] = matrix[i][last];
				matrix[i][last] = temp;
			}
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = i + 1; j < cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void zeroMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		
		
		
	}
	
	
	
	
	
	
	
		
}

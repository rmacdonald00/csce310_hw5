package code;

public class chessRook {

	public static void main(String[] args) {

		System.out.println(rookMoves(8));

	}

	// solve this under the assumption we are moving from top left to bottom right
	// because
	// it will take the same number to get between any diagonally opposite corners
	public static int rookMoves(int n) {
		int[][] matrix = new int[n+1][n+1];

		// initialize zero row and column
		for (int i = 0; i < n+1; i++) {
			matrix[i][0] = 0;
		}
		for (int j = 0; j < n+1; j++) {
			matrix[0][j] = 0;
		}

		// initialize first row and column
		matrix[1][1] = 1;
		for (int i = 2; i < n+1; i++) {
			matrix[i][1] = matrix[i - 1][1] + matrix[i - 1][0];
		}
		for (int j = 2; j < n+1; j++) {
			matrix[1][j] = matrix[1][j - 1] + matrix[0][j - 1];
		}

		// for each spot after, take sum of spot left and above it and add one
		for (int i = 2; i < n+1; i++) {
			for (int j = 2; j < n+1; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}

//		to print out the matrix if desired		
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
//				System.out.print(matrix[i][j] + " ");
				System.out.printf("%5d ", matrix[i][j]);
			}
			System.out.println();
		}
		return matrix[n][n];
	}

}

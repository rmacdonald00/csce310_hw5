package code;

public class triangleDescentSum {

	public static void main(String args[]) {

		int[][] t1 = { { 2, 0, 0, 0 }, { 5, 4, 0, 0 }, { 1, 4, 7, 0 }, { 8, 6, 9, 6 } };

		System.out.println(maxDescentSum(t1));
	}

	public static int maxDescentSum(int[][] triangle) {

		// make a matrix that has one extra row and column on the top and left to have
		// zeros
		int[][] sums = new int[triangle.length + 1][triangle.length + 1];
		for (int i = 0; i < sums.length; i++) {
			sums[i][0] = 0;
			sums[0][i] = 0;
		}

		// at each point, its max sum will be the max out of the two nodes
		// above it plus its own value
		for (int i = 1; i < sums.length; i++) {
			for (int j = 1; j < sums.length; j++) {
				sums[i][j] = Math.max(sums[i - 1][j - 1], sums[i - 1][j]) + triangle[i - 1][j - 1];
			}
		}

		// find the max value out of the bottom row
		int max = -1;
		for (int i = 0; i < sums.length; i++) {
			if (sums[sums.length - 1][i] > max) {
				max = sums[sums.length - 1][i];
			}
		}
		return max;
	}
}

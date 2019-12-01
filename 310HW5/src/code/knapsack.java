package code;

public class knapsack {
	
	public static void main(String args[]) {
		int[] weights = {2, 1, 3, 2};
		int[] values = {12, 10, 20, 15};
		
		System.out.println( knap(weights, values, 5) );
	}

	
	public static int knap(int[] weight, int[] value, int capacity) {
		
		int[][] table = new int[weight.length+1][capacity+1];
		for(int i = 0; i < table.length; i++) {
			table[i][0] = 0;
		}
		for(int i = 0; i< table[0].length; i++) {
			table[0][i] = 0;
		}
		
		for(int i = 1; i < table.length; i++) {
			for(int j = 1; j < table[0].length; j++) {
				if(j-weight[i-1] >= 0) {
					table[i][j] = Math.max(table[i-1][j], value[i-1] + table[i-1][j-weight[i-1]]);
				}else {
					table[i][j] = table[i-1][j];
				}
			}
		}
		return table[weight.length][capacity];
	}

}

package code;

public class nChooseK {

	public static void main(String args[]) {

		//6435
		System.out.println(chooseMemory(15, 8));
		//1
		System.out.println(chooseMemory(0, 0));
		//86493225
		System.out.println(chooseMemory(30, 18));

	}

	
	
	public static int chooseMemory(int n, int k) {
		int[][] table = new int[n+1][k+1];
		//generate a table to hold the results and fill with -1 to denote not calculated
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < k+1; j++) {
				table[i][j] = -1;
			}
		}
		int result = chooseInner(n, k, table);
		
		//print out result table if you want
//		for(int i = 0; i < n+1; i++) {
//			for(int j = 0; j < k+1; j++) {
//				System.out.printf("%d ", table[i][j]);			
//				}
//			System.out.println(" ");
//		}
		
		return result;
	}
	
	
	//this function contains the logic and recursive ability to generate a table of necessary values for n choose k
	//it exists so that table can function "globally"
	public static int chooseInner(int n, int k, int[][] table) {
		if(table[n][k] < 0) {
		if(k == 0 || k == n){
			table[n][k] = 1;
		}else if (k > n){
			table[n][k] =  0;
		}else {
			int value = chooseInner(n-1, k-1, table) + chooseInner(n-1, k, table);
			table[n][k] = value;
		}
		}
		return table[n][k];

	}
	
	
	//NOT USED In SOLUTION
	//this function uses dynamic programming to generate an entire table for n choose k
		public static int choose(int n, int k) {
			int[][] table = new int[n + 1][k + 1];

			// initialize left column of k=0 as table = 1
			for (int i = 0; i < n + 1; i++) {
				// k = 0
				table[i][0] = 1;
			}
			// initialize top row where k>n as table = 0
			for (int j = 1; j < k + 1; j++) {
				table[0][j] = 0;
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < k + 1; j++) {
					if (k == n) {
						table[i][j] = 1;
					} else if (k > n) {
						table[i][j] = 0;
					} else {
						table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
					}
				}
			}
			for(int i = 0; i < n+1; i++) {
				for(int j = 0; j < k+1; j++) {
					System.out.printf("%d ", table[i][j]);			
					}
				System.out.println(" ");
			}
			return table[n][k];
		}
	
}

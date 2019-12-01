package code;

public class maxSalePriceOfRodLengthN {
	
	public static void main(String args[]) {
		int n1 = 5;
		int[] p1 = {2, 3, 7, 8, 9};
		
		System.out.println(getRodPrice(n1, p1));
	}
	
	
	public static int getRodPrice(int n, int[] p) {
		
		//create "table" to hold values
		int[] results = new int[n+1];
		results[0] = 0;
		
		//i is iterating over different sizes
		for(int i = 1; i <= n; i++) {
			int max = -1;
			//j checks every size cut less than our current i value
			//p is offset by one because our table has indices of 0,1,2... but the prices were read in 1 indexed
			for(int j = 1; j <= i; j++) {
				if((results[i-j] + p[j-1]) > max) {
					max = results[i-j] + p[j-1];
				}
			}
			results[i] = max;
		}
		return results[n];
	}

}

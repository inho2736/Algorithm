	package dp3;
	import java.util.*;
	public class card {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			
			int [] dp = new int [num+1];
			int [] arr = new int [num+1];
			
			for(int i=1; i<=num; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=1; i<num+1; i++) {
				dp[i] = arr[i];
				for(int j=1; j<i; j++) {
					dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
				}
			}
			System.out.println(dp[num]);
		}
	
	}

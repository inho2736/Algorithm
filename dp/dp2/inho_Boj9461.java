package dp2;
import java.util.*;
public class inho_Boj9461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long []arr = new long [num];
		for(int i=0; i<num; i++) {
			int n = sc.nextInt();
			long [] dp = new long[n];
			for(int j=0; j<n; j++) {
				if(0 <= j && j <= 2) {
					dp[j] = 1;
				}
				else if( 3 <= j && j <= 4) {
					dp[j] = 2;
				}
				else {
					dp[j] = dp[j-5] + dp[j-1];
				}
			}
//			System.out.println(dp[n-1]);
			arr[i] = dp[n-1];
		}
		for(int i=0; i<num; i++) {
			System.out.println(arr[i]);
		}
		
	}

}

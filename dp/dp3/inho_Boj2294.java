
package dp3;
import java.util.*;
public class inho_Boj2294 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int coin [] = new int [n];
		for(int i=0; i<n; i++) {
			coin[i] = sc.nextInt();
		}
		int dp[] = new int [k+1];
		
		for(int i=1; i<=k ; i++) {
			dp[i] = 10001;
		}
		dp[0] = 0;
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j],  dp[j - coin[i]] + 1);
			}
		}
		if(dp[k] > 10000) {
			System.out.println(-1);
		}
		else {
			
			System.out.println(dp[k]);
		}
	}

}

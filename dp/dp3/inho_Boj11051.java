package dp3;
import java.util.*;
public class inho_Boj11051 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int dp[][] = new int [k+1][n+1];
		
		for(int i=0; i<=k; i++) {
			for(int j=i; j<=n; j++) {
				if(i == 0 || i == j) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i][j-1])%10007;
				}
			}
		}
		System.out.println(dp[k][n]%10007);
	}

}

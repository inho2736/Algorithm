package dp3;
import java.util.*;
public class change_Boj2293 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int coin[] = new int [n];
		for(int i=0; i<n ; i++) {
			coin[i] = sc.nextInt();
		}
		
		int dp[][] = new int[n+1][k+1];
		
		for(int i=0; i<=k; i++) {
			dp[0][i] = 0;
		}
		for(int i = 1; i<=n; i++) {
			dp[i][0] = 1;
			for(int j =1 ; j<=k; j++) {
				if(j >= coin[i-1]) {
					
					dp[i][j] = dp[i-1][j]+ dp[i][j-coin[i-1]];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
				//System.out.print(dp[i][j]);
			}
			//System.out.println();
		}
		System.out.println(dp[n][k]);
	}

}

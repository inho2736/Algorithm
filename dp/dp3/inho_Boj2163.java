package dp3;
import java.util.*;
public class inho_Boj2163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int dp[][] = new int [n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(i == 1) {
					dp[i][j] = j-1;
				}
				else if(j == 1) {
					dp[i][j] = i-1;
				}
				else {
					dp[i][j] = dp[i][1] + dp[i][j-1]+1;
				}
				
			}
		}
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=m; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(dp[n][m]);
	}

}

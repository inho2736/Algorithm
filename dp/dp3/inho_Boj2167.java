package dp3;
import java.util.*;
public class inho_Boj2167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int dp[][] = new int [n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = sc.nextInt();
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + dp[i][j];
			}
		}
		
		int k = sc.nextInt();
		
		for(int p=0; p<k; p++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			
			System.out.println(dp[x][y] - dp[x][j-1] - dp[i-1][y] + dp[i-1][j-1]);
//			int tmpi = x-i+2;
//			int tmpj = y-j+2;
//			
//			
//			for(int r=1; r<tmpi; r++) {
//				for(int t=1; t<tmpj; t++) {
//					
//					if(r == tmpi-1 && t == tmpj-1) {
//						System.out.println(dp[r][t]);
//					}
//				}
//			}
			
			
		}
	}

}

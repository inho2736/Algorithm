package dp3;
import java.util.*;
public class inho_Boj1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int dp[][] = new int [31][31];
		
		for(int k=0; k<t; k++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			for(int i=0; i<=n; i++) {
				for(int j=i; j<=m; j++) {
					if(i == 0 || i == j) {
						dp[i][j] = 1;
					}
					else {
						dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
					}
				}
			}
			System.out.println(dp[n][m]);
		}
		
		sc.close();
		
		
		
	}

}

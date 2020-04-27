package dp3;
import java.util.*;
public class inho_Boj11048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int dp[][] = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i == 0 && j==0) {
					continue;
				}
				else if(i == 0) {
					dp[i][j] += dp[i][j-1];
				}
				else if(j == 0 ) {
					dp[i][j] += dp[i-1][j];
				}
				else {
					int tmp;
					tmp = Math.max(dp[i][j-1] , dp[i-1][j] );
					tmp = Math.max(tmp , dp[i-1][j-1] );
					dp[i][j] += tmp;	
				}
			}
		}
		System.out.println(dp[n-1][m-1]);
	}

}
//package dp3;
//import java.util.*;
//public class inho_Boj11048 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int dp[][] = new int[n][m];
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				dp[i][j] = sc.nextInt();
//			}
//		}
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if(i == 0 && j==0) {
//					continue;
//				}
//				if(i == 0 && j != 0) {
//					dp[i][j] += dp[i][j-1];
//				}
//				else if(j == 0 && i != 0) {
//					dp[i][j] += dp[i-1][j];
//				}
//				else {
//					int tmp;
//					tmp = Math.max(dp[i][j-1] , dp[i-1][j] );
//					tmp = Math.max(tmp , dp[i-1][j-1] );
//					dp[i][j] += tmp;	
//				}
//			}
//		}
//		System.out.println(dp[n-1][m-1]);
//	}
//
//}

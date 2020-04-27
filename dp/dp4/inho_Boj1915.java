package dp4;

import java.util.Scanner;

public class inho_Boj1915 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [][] arr = new int [n+1][m+1];
		int [][] dp = new int [n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			String tmp = sc.next();
			for(int j=1; j<=m ;j++) {
				arr[i][j] = tmp.charAt(j-1)-'0';
			}
		}
		int max = 0;
		for(int i=1; i<= n; i++) {
			for(int j=1; j<=m; j++) {
				if(arr[i][j] == 1) {
					dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j-1]);
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j]) + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		System.out.println(max*max);
		sc.close();
	}

}

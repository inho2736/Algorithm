package another;
import java.util.*;
import java.io.*;
public class f_Boj2157_여행 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int way [][] = new int [n+1][n+1];
		int dp [][] = new int [n+1][m+1];
		for(int i=0; i<k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			if(a<b) {
				way[a][b] = Math.max(way[a][b], p);
			}
		}
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				dp[i][j] = -1;
			}
		}
		dp[1][1] = 0;
		//i를 기준으로 다음으로 하나씩 뻗어가는 식이라 n은 거치면 안됨.
		for(int i=1; i<n; i++) {
			//j는 j번만큼 거치는 것을의미.
			//i번째 도시는 i번보다 많이 거칠 수 없음 
			// 거기에 m번째 도시도 하나씩 뻗어가는 식이라 j가 직접거칠 수 없음
			// 그럼 i는 왜 되니...
			int res = Math.min(i, m-1);
			for(int j=1; j<=res; j++) {
				if(dp[i][j] != -1) {
					for(int p = i+1; p<=n; p++) {
						if(way[i][p] > 0) {
							dp[p][j+1] = Math.max(dp[p][j+1], dp[i][j]+ way[i][p]);
						}
					}
				}
			}
		}
		int result = 0;
		for(int i=1; i<=m; i++) {
			result = Math.max(result, dp[n][i]);
		}
		System.out.println(result);
		

	}

}

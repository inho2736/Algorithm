package another;
import java.util.*;
import java.io.*;

public class Boj2157_여행 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] way = new int [n+1][n+1];
		int [][] dp = new int [n+1][m+1];
		
		for(int i=0; i<k; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tmp.nextToken());
			int b = Integer.parseInt(tmp.nextToken());
			int p = Integer.parseInt(tmp.nextToken());
			
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
		for(int i=1; i<n; i++) {
			int res = Math.min(i, m-1);
			for(int j=1; j<=res; j++) {
				if(dp[i][j] != -1) {
					for(int p = i+1; p<=n; p++) {
						if(way[i][p] > 0) {
							dp[p][j+1] = Math.max(dp[p][j+1], dp[i][j] + way[i][p]);
						}
					}
				}
			}
		}
		int result = 0;
		for(int i=1; i<=m; i++) {
			result = Math.max(result, dp[n][i]);
		}
		bw.write(result);
		bw.flush();
		bw.close();
		br.close();
	}
}

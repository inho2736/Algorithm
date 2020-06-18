package dp5;
import java.util.*;
import java.io.*;
public class Boj10164_격자상의경로 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 중간에 거치는 인덱스 구하기
		int mid = Integer.parseInt(st.nextToken());
		int a = (mid-1) / m;
		int b = (mid-1) % m;
		
		
		// 기본 dp 배열 구하기
		long [][] dp = new long [n][m];
		for(int i=0; i<n; i++) {
			dp[i][0] = 1;
		}
		for(int j=0; j<m; j++) {
			dp[0][j] = 1;
		}
		
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		
		if(mid == 0) {
			bw.write(dp[n-1][m-1]+"\n");
		}
		else {
			
			bw.write(dp[a][b] * dp[n-1-a][m-1-b]+"\n");
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}

package dp1;
import java.util.*;
import java.io.*;
public class Boj11057_오르막수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] dp = new int [n][10];
		
		for(int i=0; i<10; i++) {
			dp[0][i] = 1;
		}
		for(int i=0; i<n; i++) {
			dp[i][9] = 1;
		}

		for(int i=1; i<n; i++) {
			for(int j=8; j>=0; j--) {
				dp[i][j] = (dp[i][j+1] + dp[i-1][j]) % 10007;
			}
		}
		
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum += dp[n-1][i];
		}
		bw.write(sum%10007 + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}

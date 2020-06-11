package dp5;
import java.util.*;
import java.io.*;
public class Boj5557_1학년 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [n+1];
		long [][] dp = new long[n+1][21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][arr[1]] = 1;
		
		for(int i=1; i<=n-1; i++) {
			for(int j=0; j<=20; j++) {
				if(dp[i][j] != 0) {
					if(arr[i+1] + j <= 20) {
						dp[i+1][arr[i+1] + j] += dp[i][j];
					}
					
					if( j - arr[i+1]>= 0) {
						dp[i+1][j - arr[i+1]] += dp[i][j];
					}
				}
			}
		}
		bw.write(dp[n-1][arr[n]]+ "\n");
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}

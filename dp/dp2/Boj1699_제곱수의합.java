package dp2;
import java.util.*;
import java.io.*;
public class Boj1699_제곱수의합 {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int [n+1];
		for(int i=0; i<=n; i++) {
			dp[i] = i;
		}
		for(int i=2; i<=n; i++) {
			for(int j=2; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
			}
		}
		bw.write(dp[n] +"\n");
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}

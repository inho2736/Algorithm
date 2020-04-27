package dp4;
import java.util.*;
public class F_inho_Boj1890 {
	static int n;
	static int max = 0;
	static int arr[][] = new int [100][100];
	static long dp[][] = new long [100][100];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		//입력받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dp[i][j] == 0 || (i == n-1 && j == n-1)) {
					continue;
				}
				int value = arr[i][j];
				if(value + i < n) {
					dp[value+i][j] += dp[i][j];
				}
				if(value + j < n) {
					dp[i][value+j] += dp[i][j];
				}
			}
		}
		
		
		System.out.println(dp[n-1][n-1]);
	}
	
}

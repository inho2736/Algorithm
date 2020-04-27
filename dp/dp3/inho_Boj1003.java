package dp3;
import java.util.*;
public class inho_Boj1003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int tmp;
		int dp[][] = new int[41][2];
		dp[0][0] = 1;	dp[0][1] = 0;
		dp[1][0] = 0;	dp[1][1] = 1;
		
		for(int i=0; i<testCase; i++) {
			int num = sc.nextInt();
			for(int j=2; j<=num; j++) {
				dp[j][0] = dp[j-1][0] + dp[j-2][0];
				dp[j][1] = dp[j-1][1] + dp[j-2][1];
			}
			System.out.println(dp[num][0]+" "+dp[num][1]);
		}
	}
}

package dp4;
import java.util.*;

public class inho_Boj1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int dp [][] = new int [num][3];
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;
		
		for(int i=1; i<num; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
		}
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += dp[num-1][i];
		}
		
		System.out.println(sum % 9901);
	}

}

package dp3;
import java.util.*;
public class inho_Boj1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int dp[][] = new int[num][3];
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<3; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		//최댓값을 잘 계산해라..
		int min=1000000;
		
		for(int i=1; i<num; i++) {
				
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] += Math.min(dp[i-1][1], dp[i-1][0]);
			
		}
		for(int j=0; j<3; j++) {
			min = Math.min(dp[num-1][j], min);
		}
		System.out.println(min);
	}

}

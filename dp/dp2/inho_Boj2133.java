package dp2;
import java.util.*;
public class inho_Boj2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int [] dp = new int [num+1];
		
		for(int i=2; i<=num; i+=2) {
			if(i == 2) {
				dp[i] = 3;
			}
			else {
				dp[i] = dp[i-2] * 3 + 2;
//				dp[i] = dp[i-2]*3 + dp[i-4]*2 + dp[i-6]*2;
				
				for(int j=i-4; j>=2; j-=2) {
					dp[i] += dp[j] * 2;
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[num]);
	}

}

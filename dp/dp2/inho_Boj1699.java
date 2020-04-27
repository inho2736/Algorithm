package dp2;
import java.util.*;
public class inho_Boj1699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [] dp = new int[num+1];
		for(int i=1; i<=num; i++) {
			dp[i] = i;
			for(int j=2; j*j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		System.out.println(Arrays.toString(dp));
	
	}
}

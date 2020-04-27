package dp3;
import java.util.*;
public class inho_Boj14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int p[] = new int[num+1];
		int t[] = new int[num+1];
		int dp[] = new int[num+1];
		
		for(int i=1; i<=num; i++) {
			t[i] = sc.nextInt();
			p[i]= sc.nextInt();
			dp[i] = p[i];
		}
		
		for(int i=2; i<=num; i++) {
			for(int j=1; j<i; j++) {
				if(i - j >= t[j]) {
					dp[i] = Math.max(dp[i], p[i]+dp[j]);
				}
			}
		}
		int max = 0;
		for(int i=1; i<=num; i++) {
			if(t[i] + i < num+2) {
				max = Math.max(dp[i], max);
			}
		}
		System.out.println(max);
		
	}

}

package dp2;
import java.util.Scanner;
import java.util.Arrays;

public class inho_Boj2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int [] arr = new int [num+1];
		
		int [] dp = new int [num+1];
		
		for(int i=1; i<=num; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<num+1; i++) {
			if(i == 1) {
				dp[i] = arr[1];
			}
			else if(i == 2) {
				dp[i] = dp[1] + arr[2];
			}
			else {
				dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i] , dp[i-2]+arr[i]);
				dp[i] = Math.max(dp[i], dp[i-1]);
			}
		}
		System.out.println(dp[num]);
		
		
	}

}

package dp2;
import java.util.Scanner;
import java.util.Arrays;

public class inho_Boj11055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int [] arr = new int [num];
		
		int [] dp = new int [num];
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}
		
		int max = 0;
		for(int i=1; i<num; i++) {
			for(int j= 0; j<i; j++) {
				if (arr[j] < arr[i] && dp[j]+arr[i] > dp[i]) {
					dp[i] = dp[j]+arr[i];
				}
			}
			if(dp[i]> max) {
				max = dp[i];
			}
		}
		System.out.println(max);
		sc.close();
		
		
	}

}

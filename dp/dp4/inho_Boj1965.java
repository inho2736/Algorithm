package dp4;
import java.util.*;
public class inho_Boj1965 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num];
		int dp[] = new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		int max = 1;
		for(int i=0; i<num; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i] && dp[j]+1 > dp[i]) {
					dp[i] = dp[j]+1;
					max = Math.max(dp[i], max);
				}
			}
		}
		System.out.println(max);
	}

}

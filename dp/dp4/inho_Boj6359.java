package dp4;
import java.util.*;
public class inho_Boj6359 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		int dp[] = new int[101];
		int arr[] = new int[101];
		int result = 0;
		
		for(int i=1; i<=100; i++) {
			for(int j=i; j<=100; j+=i) {
				dp[j] += 1;
				
				if(i == j && (dp[i]%2 == 1)) {
					result++;
				}
			}
			
			arr[i] = result;
		}
		
		for(int k=0; k<testcase; k++) {
			int num = sc.nextInt();
			System.out.println(arr[num]);
		}
	}

}

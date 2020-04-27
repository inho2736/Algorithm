package dp2;
import java.util.Scanner;
import java.util.Arrays;
public class Boj11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int [] arr = new int [num];
		int [] dp = new int [num];
		
		for (int i=0; i<num; i++) {
			dp[i] = sc.nextInt();
			arr[i] = 1;
		}
		int max = 1;
		for ( int i=1; i<num; i++) {
			for (int j=0; j<i; j++) {
				if (dp[i] > dp[j] && arr[i] < arr[j]+1) {
					arr[i] = arr[j]+1;
				}
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		System.out.println(max);
		sc.close();
	}

}

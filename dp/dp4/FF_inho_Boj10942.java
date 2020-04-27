package dp4;
import java.util.*;
public class FF_inho_Boj10942 {
//이게 시간초과 뜨는 이유가 궁금하다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr [] = new int [n];
		int dp [][] = new int [n][n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			for(int j=0; j<=i; j++) {
				if(arr[i] == arr[j] && (j >= i-1 || dp[i-1][j+1] == 1)) {
					dp[i][j] = 1;
				}
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int m = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(dp[y-1][x-1]);
		}
		sc.close();
	}

}

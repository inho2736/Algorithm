package dp4;
import java.util.*;
public class F_inho_Boj10942 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr [] = new int [n];
		int dp [][] = new int [n][n];
		int bf = -1;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(bf == arr[i]) {
				dp[i-1][i] = 1;
			}
			dp[i][i] = 1;
			bf = arr[i];
		}
		
		///ver2//
		for(int k=0; k<n; k++) {
			for(int l = 0; l<2; l++) {
				int i;
				int j;
				if( l == 0) {
					i = k;
					j=i;
				}
				else {
					i = k;
					j=i+1;
				}
				i--;
				j++;
				while(i>=0 && j>=0 && i<n && j<n) {
					if(arr[i] == arr[j]) {
						dp[i][j] = 1;
						i--;
						j++;
					}
					else {
						break;
					}
				}
			}
			
			
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		
		
		///ver1/////
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n - i; j++) {
//				if(i == 0) {
//					dp[j][j+i] = 1;
//				}
//				else if(i == 1) {
//					if(arr[j] == arr[j+i]) {
//						dp[j][j+i] = 1;
//					}
//				}
//				else {
//					if((dp[j+1][j+i-1] == 1)&& (arr[j] == arr[j+i])) {
//						dp[j][j+i] = 1;
//					}
//				}
//			}
//		}
		//////
		int m = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(dp[x-1][y-1]);
		}
		sc.close();
		
		
		
	}

}

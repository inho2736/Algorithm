package dp4;
import java.util.*;
public class F_inho_Boj1937 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int [n][n];
		int dp[][] = new int [n][n];
		
		//입력받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//
		int result = 0;
		boolean flag = false;
		for(int i=0; i<n*n; i++) {
			flag = false;
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(dp[j][k] == i) {
						if(j > 0) {
							if(arr[j-1][k] > arr[j][k]) {
								dp[j-1][k] = i + 1;
								flag = true;
								result = i+1;
							}
						}
						if(k > 0) {
							if(arr[j][k-1] > arr[j][k]) {
								dp[j][k-1] = i + 1;
								flag = true;
								result = i+1;
							}
						}
						if(j < n-1) {
							if(arr[j+1][k] > arr[j][k]) {
								dp[j+1][k] = i + 1;
								flag = true;
								result = i+1;
							}
						}
						if(k < n-1) {
							if(arr[j][k+1] > arr[j][k]) {
								dp[j][k+1] = i + 1;
								flag = true;
								result = i+1;
							}
						}
					}
				}
			}
			if(flag == false) {
				break;
			}
		}
		System.out.println(result+1);
		
		
	}

}

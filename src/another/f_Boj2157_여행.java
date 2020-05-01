package another;
import java.util.*;
public class f_Boj2157_여행 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int dp [][] = new int [n+1][n+1];
		int dp_m [][] = new int [n+1][n+1];
		for(int i=0; i<k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			if(a<b) {
				dp[a][b] = Math.max(dp[a][b], p);
			}
		}
		
		
		
//		for(int i=0; i<=n; i++) {
//			for(int j=0; j<=n; j++) {
//				System.out.print(dp[i][j]+ ' ');
//			}
//			System.out.println();
//		}
	}

}

package dp4;
import java.util.*;
public class FF_inho_Boj1937 {
	static int n;
	static int max = 0;
	static int arr[][] ;
	static int dp[][] ;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int [n][n];
		dp = new int [n][n];
		//입력받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dp[i][j] == 0) {
					dp[i][j] = 1;
					dfs(i, j);
				}
			}
		}
		//debug
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(max);
	}
	public static void dfs(int x, int y) {
		
		int nextX, nextY;
		for(int i=0; i<4; i++) {
			nextX = x + dx[i];
			nextY = y + dy[i];
			
			if(nextX < 0 || nextY <0 || nextY >= n || nextX >= n) {
				continue;
			}
			
			if(arr[x][y] < arr[nextX][nextY] && dp[x][y]+1 > dp[nextX][nextY] ) {
				dp[nextX][nextY] = dp[x][y] +1;
				max = Math.max(max, dp[nextX][nextY]);
				dfs(nextX, nextY);
			}
		}
	}

}

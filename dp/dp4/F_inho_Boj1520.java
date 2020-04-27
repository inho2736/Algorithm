package dp4;
import java.util.*;
public class F_inho_Boj1520 {
	static int n;
	static int m;
	static int max = 0;
	static int arr[][] = new int [500][500];
	static int dp[][] = new int [500][500];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		//입력받기
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		//debug
		System.out.println("");
		System.out.println(dfs(0,0));
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int dfs(int x, int y) {
		if(x == m-1 && y == m-1) {
			return 1;
		}
		int nextX, nextY;
		if(dp[x][y] == 0) {
			for(int i=0; i<4; i++) {
				nextX = x + dx[i];
				nextY = y + dy[i];
				
				if(nextX < 0 || nextY <0 || nextY >= n || nextX >= n) {
					continue;
				}
				
				if(arr[x][y] > arr[nextX][nextY] ) {
					dp[x][y] += dfs(nextX, nextY);
				}
			}
		}
		
		return dp[x][y];
	}

}

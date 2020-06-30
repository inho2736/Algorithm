package Dfs1;
import java.util.*;
import java.io.*;
public class Boj2468_안전영역 {
	static int [][] arr;
	static boolean [][] check;
	static int n;
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
	static int rain;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//
		int max = 0;
		for(int i = 0; i<=100; i++) {
			rain = i;
			check = new boolean [n][n];
			max = Math.max(max, calculate(i));
		}
		bw.write(max+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
	private static int calculate(int a) {
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] > rain && !check[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		
		
		return count;
	}
	private static void dfs(int x, int y) {
		check[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int tmpx = x + dx[i];
			int tmpy = y + dy[i];
			
			if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= n) {
				continue;
			}
			
			if(!check[tmpx][tmpy] && arr[tmpx][tmpy] > rain ) {
				dfs(tmpx, tmpy);
			}
		}
		
	}

}

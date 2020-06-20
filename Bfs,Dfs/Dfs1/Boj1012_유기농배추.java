package Dfs1;
import java.util.*;
import java.io.*;
public class Boj1012_유기농배추 {
	static int n;
	static int m;
	static int [][] map;
	static boolean [][] check;
	static int [] dy = {1, 0, -1, 0};
	static int [] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			map = new int [n][m];
			check = new boolean [n][m];
			for(int j=0; j<k; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				map[b][a] = 1;
			}
			int count = 0;
			for(int p=0; p<n; p++) {
				for(int j=0; j<m; j++) {
					if (map[p][j] == 1 && !check[p][j]) {
						dfs(p, j);
						count++;
					}
				}
			}
			bw.write(count+"\n");
			
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static void dfs(int x, int y) {
		check[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int tmpx = x + dx[i];
			int tmpy = y + dy[i];
			
			if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
				continue;
			}
			
			if(map[tmpx][tmpy] == 1 && !check[tmpx][tmpy]) {
				dfs(tmpx, tmpy);
			}
		}
	
	}
}

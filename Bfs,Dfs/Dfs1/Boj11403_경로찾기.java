package Dfs1;
import java.util.*;
import java.io.*;
public class Boj11403_경로찾기 {

	static int [][] map;
	static int n;
	static int [][] result;
	static boolean [] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		result = new int [n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		for(int i=0; i<n; i++) {
			check = new boolean [n];
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					dfs(i, j, i);
				}
			}
			
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	private static void dfs(int x, int y, int a) {
		
		result[a][y] = 1;
		for(int i=0; i<n; i++) {
			if(map[y][i] == 1 && !check[i]) {
				check[i] = true;
				dfs(y, i, a);
			}
		}
		
	}

}

package Bfs2;
import java.util.*;
import java.io.*;
public class Boj2589_보물섬 {
	static char [][] map;
	
	static int n;
	static int m;
	static int result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char [n][m];
	
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		bw.write(result + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	private static void bfs(int a, int b) {
		boolean [][] check = new boolean [n][m];
		int [][] distance = new int [n][m];
		Queue <int []> queue = new LinkedList<int []>();
		queue.offer(new int [] {a, b});
		check[a][b] = true;
		
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
					continue;
				}
				
				if(map[tmpx][tmpy] == 'L' && !check[tmpx][tmpy]) {
					queue.offer(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
					distance[tmpx][tmpy] = distance[x][y] + 1;
					result = Math.max(distance[tmpx][tmpy], result);
				}
			}
			
		}
		
	}

}

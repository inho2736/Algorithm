package Bfs1;
import java.util.*;
import java.io.*;
public class Boj7576_토마토 {
	static int [][] map;
	static int n;
	static int m;
	static boolean [][] check;
	//static boolean isChanged = false;
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int [n][m];
		for(int i=0; i<n; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp.nextToken());
			}
		}
		
		check = new boolean[n][m];
		
		bw.write(bfs()+"\n");
		bw.flush();
		bw.close();
		br.close();

	}
	
	public static int bfs() {
		Queue<int []> queue = new LinkedList<int []>();
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && check[i][j] == false) {
					queue.offer(new int [] {i, j});
					check[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpx = x+dx[i];
				int tmpy = y+dy[i];
				
				if(tmpx <0 || tmpy<0 || tmpx >=n || tmpy>= m) {
					continue;
				}
				
				if(map[tmpx][tmpy] == 0 && !check[tmpx][tmpy]) {
					queue.offer(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
					map[tmpx][tmpy] = map[x][y] + 1;
				}
			}
		}
		
		int result=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					return -1;
				}
				result = Math.max(result, map[i][j]);
			}
		}
		return result-1;
	}

}

package Bfs2;
import java.util.*;
import java.io.*;
public class Boj7562_나이트의이동 {
	static int [][] map;
	static boolean [][] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			
			map = new int [n][n]; 
			check = new boolean [n][n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st2.nextToken());
			int ey = Integer.parseInt(st2.nextToken());
			if(x == ex && y == ey) {
				bw.write(0 + "\n");
			}
			else {
				int result = bfs(n, x, y, ex, ey);
				bw.write(result + "\n");
			}
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int bfs(int n, int a, int b, int ex, int ey) {
		int count = 0;
		Queue<int []> queue = new LinkedList<int []>();
		int [] dx = {-2, -2, -1 ,-1, 1, 1, 2, 2};
		int [] dy = {1, -1, 2, -2, 2, -2, 1, -1};
		
		queue.offer(new int [] {a, b});
		check[a][b] = true;
		
		while(!queue.isEmpty()) {
			int tmp [] = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int value = map[x][y];
			for(int i=0; i<8; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= n) {
					continue;
				}
				
				if(map[tmpx][tmpy] == 0) {
					if(tmpx == ex && tmpy == ey) {
						return value + 1;
					}
					
					map[tmpx][tmpy] = value + 1;
					queue.add(new int [] {tmpx, tmpy});
					
				}
			}
			
		}
		
		return count;
	}

}

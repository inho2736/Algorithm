package Bfs2;
import java.util.*;
import java.io.*;
public class Boj3055_탈출 {
	static int n;
	static int m;
	static char [][] map;
	static int sx, sy;
	static int dx, dy;
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Queue <int []> queue = new LinkedList<int []>();
		map = new char [n][m];
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				char temp = tmp.charAt(j);
				if(temp == 'S') {
					sx = i;	sy = j;
					map[i][j] = '.';
					continue;
				}
				else if(temp == 'D') {
					dx = i; dy = j;
				}
				else if(temp == '*') {
					queue.offer(new int [] {i, j, 5});
				}
				map[i][j] = temp;
				
			}
		}
		queue.offer(new int [] {sx, sy, 2});
		int result = bfs(queue);
		if(result == -1) {
			bw.write("KAKTUS\n");
		}
		else {
			bw.write(result+"\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}
	private static int bfs(Queue <int []> queue) {
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		int [][] dist  = new int[n][m];
		int result = -1;
		loop:
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int value = tmp[2];
			//물일때
			if(value == 5) {
				for(int i=0; i<4; i++) {
					int tmpx = x + dx[i];
					int tmpy = y + dy[i];
					
					if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
						continue;
					}
					if(map[tmpx][tmpy] == '.') {
						map[tmpx][tmpy] = '*';
						queue.offer(new int [] {tmpx, tmpy, 5});
						//visit[tmpx][tmpy] = true; //꼭필요한가?
					}
				}
			}
			else if(value == 2) {
				int distance = dist[x][y];
				for(int i=0; i<4; i++) {
					int tmpx = x + dx[i];
					int tmpy = y + dy[i];
					
					if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
						continue;
					}
					if(map[tmpx][tmpy] == '.' && dist[tmpx][tmpy] == 0) {
						
						queue.offer(new int [] {tmpx, tmpy, 2});
						dist[tmpx][tmpy] = distance + 1; //꼭필요한가?
					}
					else if(map[tmpx][tmpy] == 'D') {
						result = distance + 1;
						break loop;
					}
				}
			}
			
		}
		return result;
		
		
		
	}
}

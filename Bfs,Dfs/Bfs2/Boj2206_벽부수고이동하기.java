package Bfs2;
import java.util.*;
import java.io.*;
public class Boj2206_벽부수고이동하기 {
	static int [][] map;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				char temp = tmp.charAt(j);
				map[i][j] = Integer.parseInt(Character.toString(temp));
			}
		}
	
		bw.write(bfs() + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	private static int bfs() {
		
		// 한칸짜리 예외(뒤에 bfs식은 가지가 한번 뻗어간 후 체크하므로)
		if(n == 1 && m == 1 && map[0][0] == 0) {
			return 1;
		}
		
		// 벽을 부쉈을때와 안부쉈을때
		// 처음엔 방문여부를 하나로 통일하려 했는데
		// 안부쉈을 때 돌아돌아서 '부쉈을때 지름길로 갔던 곳'에 다시 도착 후 
		// 그 경로에서 이후에 벽을 부숴서 아까 지금길로간거보다 더 빨리도착할 경우를 생각해보면
		// 단순히 방문여부를 하나로 통일해서 구하는 거로는 못구하는 방식도 있다는 것을 알게된다.
		// 즉, (먼저부수고 + 돌아돌아가기) vs (돌아돌아갔다가 + 벽부수고가기) 를 비교하려면
		// 두 배열을 따로둬야한다.
		
		int dist [][][] = new int [2][n][m];
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		int count = -1;
		Queue <int []> queue = new LinkedList<int []>();
		queue.offer(new int [] {0, 0, 0});
		dist[0][0][0] = 1;
		
		loop:
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int hasBroken = tmp[2];
			int value = dist[hasBroken][x][y];
			
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
					continue;
				}
				if(tmpx == n-1 && tmpy == m-1) {
					count = value + 1;
					break loop;
				}
				//부순적 없음
				if(hasBroken == 0) {
					if(map[tmpx][tmpy] == 0 && dist[0][tmpx][tmpy] == 0) {
						queue.offer(new int [] {tmpx, tmpy, 0});
						dist[0][tmpx][tmpy] = value + 1;
					}
					else if(map[tmpx][tmpy] == 1 && dist[1][tmpx][tmpy] == 0) {
						queue.offer(new int [] {tmpx, tmpy, 1});
						dist[1][tmpx][tmpy] = value + 1;
					}
				}
				// 부순적 있음
				else {
					if(map[tmpx][tmpy] == 0 && dist[1][tmpx][tmpy] == 0) {
						queue.offer(new int [] {tmpx, tmpy, 1});
						dist[1][tmpx][tmpy] = value + 1;
					}
				}				
			}
		}
		return count;
	}
}

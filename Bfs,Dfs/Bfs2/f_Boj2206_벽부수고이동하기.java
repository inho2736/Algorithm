// 시간초과로 통과하지 못한 코드
// 존재하는 모든 벽을 하나씩 부수고 최단거리를 구해 최솟값을 출력하는 방식이다.

package Bfs2;
import java.util.*;
import java.io.*;
public class f_Boj2206_벽부수고이동하기 {
	static int [][] map;
	static boolean [][] check;
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
		check = new boolean [n][m];
		
		boolean isThere1 = false;
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				char temp = tmp.charAt(j);
				if(temp == '1') {
					isThere1 = true;
				}
				map[i][j] = Integer.parseInt(Character.toString(temp));
			}
		}
		
		int min = 1000000000;
		if(isThere1) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 1) {
						check = new boolean [n][m];
						map[i][j] = 0;
						int tmp = bfs();
						if(tmp == -1) {
							map[i][j] = 1;							
							continue;
						}
						else {
							min = Math.min(min, tmp);
						}
						map[i][j] = 1;
						
					}
				}
			}
		}
		else {
			min = bfs();
		}
		
		if(min == 1000000000) {
			bw.write(-1+"\n");
		}
		else {
			bw.write(min+"\n");
		}
		
		//bw.write(bfs() + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	private static int bfs() {
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		int count = -1;
		Queue <int []> queue = new LinkedList<int []>();
		queue.offer(new int [] {0, 0, 1});
		
		loop:
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int value = tmp[2];
			
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
					continue;
				}
				if(map[tmpx][tmpy] == 0 && !check[tmpx][tmpy]) {
					
					queue.offer(new int [] {tmpx, tmpy, value+1});
					check[tmpx][tmpy] = true;
					
					if(tmpx == n-1 && tmpy == m-1) {
						count = value + 1;
						break loop;
					}
				}
				
				
				
			}
		}
		
		
		return count;
	}

}

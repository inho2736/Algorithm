// 반례로 통과하지 못한 코드
// 빨간 구슬이 이동할 수 있는 경로만 큐에 추가할 것이 아니라
// 파란 구슬만 이동할 경우에도 큐에 추가해야함.

package Bfs2;
import java.util.*;
import java.io.*;
public class f_Boj13460_구슬탈출 {
	static int n;
	static int m;
	static char [][] map;
	static boolean [][] check;
	static int [] whereO = new int [2];
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char [n][m];
		check = new boolean [n][m];
		
		int rx = 0;
		int ry= 0;
		int bx= 0;
		int by= 0;
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				char ch = tmp.charAt(j);
				if(ch == 'R') {
					rx = i;
					ry = j;
					map[i][j] = '.';
				}
				else if(ch == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';

				}
				else if(ch == 'O') {
					whereO[0] = i;
					whereO[1] = j;
					map[i][j] = ch;

				}
				else {
					map[i][j] = ch;

				}
			}
		}
		bw.write(bfs(rx, ry, bx, by) + "\n");
		
		/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}*/
		
		
		
		br.close();
		bw.flush();
		bw.close();

	}
	private static int bfs(int a, int b, int c, int d) {
		int count = -1;
		Queue <int []> queue = new LinkedList<int []>();
		
		queue.offer(new int [] {a, b, c, d, 0});
		
		loop:
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int rx = tmp[0];
			int ry = tmp[1];
			int bx = tmp[2];
			int by = tmp[3];
			int value = tmp[4];
			
			if(value >= 10) {
				count = -1;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int tmpx = rx + dx[i];
				int tmpy = ry + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
					continue;
				}
				
				if(map[tmpx][tmpy] == '.' || map[tmpx][tmpy] == 'O' ) {
					
					if (bx == tmpx && by == tmpy ) {
						char pp = map[tmpx + dx[i]][tmpy + dy[i]];
						if(map[tmpx + dx[i]][tmpy + dy[i]]== '#') {
							continue;
						}
						;
					}
					// 새로운 빨간, 파란 구슬의 좌표를 얻음
					// 거기에 회차수도 껴서 배열만들어 큐에 넣기
					int [] next = goStraight(rx, ry, bx, by, i);
					int [] renext = new int [5];
					
					if(next[0] == -1) {
						continue;
					}
					else if(next[0] == 0) {
						count = value + 1;
						break loop;
					}
					renext[0] = next[0];
					renext[1] = next[1];
					renext[2] = next[2];
					renext[3] = next[3];
					renext[4] = value + 1;
					queue.offer(renext);
				}
			}
		}
		
		
		return count;
	}
	private static int[] goStraight(int rx, int ry, int bx, int by, int i) {
		// 구슬이 겹치지 않기 위해서..
		// 방향코드를 보고
		// 
		// 해당 방향에 어떤 구슬이 더 앞서있는지 파악해서
		// 앞선 구슬이 먼저 이동
		boolean redFlag = false;
		boolean blueFlag = false;
		
		int [] redtmp;
		int [] bluetmp;
		if(i == 0) {
			// 0, 1
			if(ry > by) {
				// 빨간구슬 이동
				redtmp = moveRed(rx, ry, bx, by, i);
				
				// 파란구슬 이동
				bluetmp = moveBlue(redtmp[0], redtmp[1], bx, by, i);
			}
			else {
				// 반대
				bluetmp = moveBlue(rx, ry, bx, by, i);
				redtmp = moveRed(rx, ry, bluetmp[0], bluetmp[1], i);

			}
		}
		else if(i == 1) {
			//1, 0
			if(rx > bx) {
				// 빨간구슬 이동
				// 파란구슬 이동
				redtmp = moveRed(rx, ry, bx, by, i);
				bluetmp = moveBlue(redtmp[0], redtmp[1], bx, by, i);

			}
			else {
				// 반대
				bluetmp = moveBlue(rx, ry, bx, by, i);
				redtmp = moveRed(rx, ry, bluetmp[0], bluetmp[1], i);

			}
		}
		else if(i == 2) {
			//0, -1
			if(ry > by) {
				// 파란구슬 이동
				// 빨간구슬 이동
				bluetmp = moveBlue(rx, ry, bx, by, i);
				redtmp = moveRed(rx, ry, bluetmp[0], bluetmp[1], i);

			}
			else {
				// 반대
				redtmp = moveRed(rx, ry, bx, by, i);
				bluetmp = moveBlue(redtmp[0], redtmp[1], bx, by, i);

			}
		}
		else {
			if(rx > bx) {
				// 파란구슬 이동
				// 빨간구슬 이동
				bluetmp = moveBlue(rx, ry, bx, by, i);
				redtmp = moveRed(rx, ry, bluetmp[0], bluetmp[1], i);

			}
			else {
				// 반대
				redtmp = moveRed(rx, ry, bx, by, i);
				bluetmp = moveBlue(redtmp[0], redtmp[1], bx, by, i);

			}
		}
		if (redtmp[2] == 1) {
			redFlag = true;
		}
		if(bluetmp[2] == 1) {
			blueFlag = true;
		}
		
		int [] result = new int [4];
		if(blueFlag) {
			//큐에 안넣을 것이니 특정 값 넣기
			result[0] = -1;
		}
		else if(redFlag) {
			// 성공케이스 특정값 넣기
			result[0] = 0;
		}		
		else {
			//큐에 넣을 정상적인 값
			result[0] = redtmp[0];
			result[1] = redtmp[1];
			result[2] = bluetmp[0];
			result[3] = bluetmp[1];
		}
		
		return result;
	}
	private static int[] moveRed(int rx, int ry, int bx, int by, int i) {
		int next_rx = rx ;
		int next_ry = ry ;
		
		boolean redFlag = false;
		while(true) {
			char tmp = map[next_rx + dx[i]][next_ry + dy[i]];
			if(tmp == '#' || (next_rx + dx[i] == bx && next_ry + dy[i]== by)) {
				break;
			}
			else if(tmp == 'O'){
				redFlag = true;
				next_rx = 0;
				next_ry = 0;
				break;
			}
			next_rx += dx[i];
			next_ry += dy[i];
		}
		int [] tmp = new int [3];
		tmp[0] = next_rx;
		tmp[1] = next_ry;
		if(redFlag) {
			tmp[2] = 1;
		}
		return tmp;
		
	}
	private static int[] moveBlue(int rx, int ry, int bx, int by, int i) {
		int next_bx = bx ;
		int next_by = by ;
		
		boolean blueFlag = false;
		while(true) {
			char tmp = map[next_bx + dx[i]][next_by + dy[i]];
			if(tmp == '#' || (next_bx + dx[i] == rx && next_by+ dy[i] == ry)) {
				break;
			}
			else if(tmp == 'O'){
				blueFlag = true;
				next_bx = 0;
				next_by = 0;
				break;
			}
			next_bx += dx[i];
			next_by += dy[i];
		}
		int [] tmp = new int [3];
		tmp[0] = next_bx;
		tmp[1] = next_by;
		if(blueFlag) {
			tmp[2] = 1;
		}
		return tmp;
	}
	

}

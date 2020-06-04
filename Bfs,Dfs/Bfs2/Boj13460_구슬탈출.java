package Bfs2;
import java.util.*;
import java.io.*;
public class Boj13460_구슬탈출 {
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
		
		int rx;
		int ry;
		int bx;
		int by;
		
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
		bfs(rx, ry, bx, by);
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
		int count = 0;
		Queue <int []> queue = new LinkedList<int []>();
		
		queue.offer(new int [] {a, b, c, d, 0});
		
		while(queue.isEmpty()) {
			int [] tmp = queue.poll();
			int rx = tmp[0];
			int ry = tmp[1];
			int bx = tmp[2];
			int by = tmp[3];
			int value = tmp[4];
			
			for(int i=0; i<4; i++) {
				int tmpx = rx + dx[i];
				int tmpy = ry + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
					continue;
				}
				
				if(map[tmpx][tmpy] == '.' || map[tmpx][tmpy] == 'O') {
					// 새로운 빨간, 파란 구슬의 좌표를 얻음
					// 거기에 회차수도 껴서 배열만들어 큐에 넣기
					int [] next = goStraight(rx, ry, bx, by, i);
				}
			}
		}
		
		
		return 0;
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
		else if(i == 3) {
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
		
		if(redFlag) {
			if(blueFlag) {
				// 이 케이스는 넘어가야 함 
			}
			else {
				// 성공한 케이스
			}
		}
		
		return;
	}
	private static int[] moveRed(int rx, int ry, int bx, int by, int i) {
		int next_rx = rx ;
		int next_ry = ry ;
		
		boolean redFlag = false;
		while(true) {
			char tmp = map[next_rx + dx[i]][next_ry + dy[i]];
			if(tmp == '#' || (next_rx == bx && next_ry == by)) {
				break;
			}
			else if(tmp == 'O'){
				redFlag = true;
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
			if(tmp == '#' || (next_bx == rx && next_by == ry)) {
				break;
			}
			else if(tmp == 'O'){
				blueFlag = true;
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

package Bfs1;
import java.util.*;
import java.io.*;
public class Boj7569_토마토 {
	static int [][][] map;
	static boolean [][][] check;
	static int n;
	static int m;
	static int h;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int [h][n][m];
		check = new boolean [h][n][m];
		
		// 입력받기
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				StringTokenizer tmp = new StringTokenizer(br.readLine());
				for(int k=0; k<m; k++) {
					map[i][j][k] = Integer.parseInt(tmp.nextToken());
				}
			}
		}
		/*for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					bw.write(map[i][j][k] + " ");
				}
				bw.write("\n");
			}
			bw.write("\n");
		}*/
		//훑기
		bfs();
		
		/*for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					bw.write(map[i][j][k] + " ");
				}
				bw.write("\n");
			}
			bw.write("\n");
		}*/
		// 검사
		int max = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					max = Math.max(max, map[i][j][k]);
					if(map[i][j][k] == 0) {
						bw.write(-1+ "\n");
						bw.flush();
						bw.close();
						br.close();
						return;
					}
				}
			}
		}
		
//		if(max == 1) {
//			bw.write(0+"\n");
//		}
//		else {
//		}
		bw.write(max-1 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs() {
		Queue<int []> queue = new LinkedList<int []>();
		int [] dh = {0, 0, 0, 0, 1, -1};
		int [] dy = {1, 0, -1, 0, 0, 0};
		int [] dx = {0, 1, 0, -1, 0, 0};
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(map[i][j][k] == 1 && !check[i][j][k]) {
						queue.add(new int [] {i, j, k});
						check[i][j][k] = true;
					}
				}
			}
		}
		
		
		
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int th = tmp[0];
			int y = tmp[1];
			int x = tmp[2];
			int value = map[th][y][x];
			for(int i=0; i<6; i++) {
				int tmph = th + dh[i];
				int tmpy = y + dy[i];
				int tmpx = x + dx[i];
				
				if(tmph < 0 || tmpy < 0 || tmpx < 0 || tmph >= h || tmpy >= n || tmpx >= m) {
					continue;
				}
				if(map[tmph][tmpy][tmpx] == 0 && !check[tmph][tmpy][tmpx]) {
					map[tmph][tmpy][tmpx] = value + 1;
					queue.add(new int [] {tmph, tmpy, tmpx});
				}
			}
		}
	}

}

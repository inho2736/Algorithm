package Bfs2;
import java.util.*;
import java.io.*;
public class Boj2573_빙산 {
	static int n;
	static int m;
	static int [][] map;
	static int [][] meltingArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int [n][m];
		
		for(int i=0; i<n; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				if(i ==0 || j == 0 || i == n-1 || j == m-1) {
					map[i][j] = 0;
					tmp.nextToken();
				}
				else {
					map[i][j] = Integer.parseInt(tmp.nextToken());
				}
			}
		}
		int count = 0;
		while(true) {
			count++;
			meltingArr = new int [n][m];
			//멜팅 배열 구하기 
			makeMeltingArr();
			// 멜팅 빼기 
			subMeltingArr();
			// 0 = 한뭉텅이 (다시 돌아라)
			// 1 = 분리됨
			// -1 = 전부 0
			int result = isDeparted();
			if(result == -1) {
				count = 0;
				break;
			}
			else if(result == 1) {
				break;
			}
		}
		bw.write(count+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
	private static void subMeltingArr() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int tmp = map[i][j] - meltingArr[i][j];
				if (tmp < 0) {
					map[i][j] = 0;
				}
				else {
					map[i][j] = tmp;
				}
			}
		}
	}
	
	private static void makeMeltingArr() {
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] > 0) {
					for(int k=0; k<4; k++) {
						if(map[i + dx[k]][j + dy[k]] == 0) {
							meltingArr[i][j]++;
						}
					}
				}
			}
		}
	}
	
	// 첫 0이아닌 수에 bfs돌리고 체크배열에 체크
	// 다시 map을 순회하며 체크되지 않은 0이 있을 경우 분리된 것이므로 true리턴
	private static int isDeparted() {
		boolean result = false;
		boolean [][] check = new boolean[n][m];
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		loop:
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] > 0) {
					result = true;
					Queue <int []> queue = new LinkedList<int []>();
					queue.offer(new int [] {i, j});
					check[i][j] = true;
					
					while(!queue.isEmpty()) {
						int tmp [] = queue.poll();
						int x = tmp[0];
						int y = tmp[1];
						
						for(int k=0; k<4; k++) {
							int tmpx = x + dx[k];
							int tmpy = y + dy[k];
							
							if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
								continue;
							}
							if(map[tmpx][tmpy] > 0 && !check[tmpx][tmpy]) {
								queue.offer(new int [] {tmpx, tmpy});
								check[tmpx][tmpy] = true;
							}
						}
					}
					break loop;
				}
			}
		}
		if(!result) {
			// 전부 0
			return -1;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] > 0 && !check[i][j]) {
					// 분리됨
					return 1;
				}
			}
		}
		
		//한뭉텅이임
		return 0;
	}

}

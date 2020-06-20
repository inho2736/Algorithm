package Dfs1;
import java.util.*;
import java.io.*;
public class f_Boj1987_알파벳 {
	static int n;
	static int m;
	static char [][] map;
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
			for(int j=0;j<m; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		int result = bfs();
		bw.write(result + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
//	 왠지 bfs가 익숙하고 이 방법으로도 풀 수 있을거라 생각했는데 
//	 이 문제는 dfs와 백트래킹을 이용하는 문제라고 한다.
//	 매 분기점마다의 체크배열이 달라지고, 이걸 전부 큐로 담아서 기억하기엔 큐의 용량이 부족하다고 한다.
//	 가로세로 크기가 작은 맵에서는 정상적인 값이 나왔지만, 크면 오차가 났는데 그 이유때문인것 같다
	private static int bfs() {
		int count = 1;
		
		int [][] distance = new int [n][m];
		distance[0][0] = 1;
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		Queue<int []> queue = new LinkedList<int []>();
		int [] start = new int [28];
		start[map[0][0]-65 +2] = 1;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int value = distance[x][y];
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx <0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
					continue;
				}
				
				int tmpvalue = map[tmpx][tmpy] - 65 +2;
				if(tmp[tmpvalue] == 0 && distance[tmpx][tmpy] == 0) {
					int [] newtmp = new int [28];
					for(int j=2; j<28; j++) {
						newtmp[j] = tmp[j];
					}
					newtmp[tmpvalue] = 1;
					distance[tmpx][tmpy] = value + 1;
					count = Math.max(count, value+1);
					newtmp[0] = tmpx;
					newtmp[1] = tmpy;
					queue.offer(newtmp);
				}
			}
		}
		return count;
	}
	
	private static int dfs() {
		return 1;
	}
	

}

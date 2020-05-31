package Bfs2;
import java.util.*;
import java.io.*;
public class Boj14502_연구소 {
	static int [][] map;
	static int [][] copy;
	static boolean [][] check;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		copy = new int [n][m];
		
		for(int i=0; i<n; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp.nextToken());
			}
		}
		
		// 벽 3개 세우기
		int max = 0;
		for(int i=0; i<n*m; i++) {
			for(int j=i+1; j<n*m; j++) {
				for(int k=j+1; k<n*m; k++) {
					if(map[i/m][i%m] == 0 && map[j/m][j%m] == 0 && map[k/m][k%m] == 0 ) {
						copyMap();
						copy[i/m][i%m] = 1;
						copy[j/m][j%m] = 1;
						copy[k/m][k%m] = 1;
						check = new boolean [n][m];
						max = Math.max(max, spreadAndCount());
					}
				}
			}
		}
		
		bw.write(max+ "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void bfs(int a, int b) {
		Queue<int []> queue = new LinkedList<int []>();
		
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		
		queue.offer(new int [] {a, b});
		check[a][b] = true;
		
		while(!queue.isEmpty()) {
			int tmp [] = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m ) {
					continue;
				}
				
				if(copy[tmpx][tmpy] == 0 && !check[tmpx][tmpy]) {
					copy[tmpx][tmpy] = 2;
					queue.offer(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
				}
			}
		}
	}
	private static int spreadAndCount() {
		
		int count = 0;
		
		//spread virus
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy[i][j] == 2) {
					bfs(i, j);
				}
			}
		}
		
		//count safe area
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	private static void copyMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
}







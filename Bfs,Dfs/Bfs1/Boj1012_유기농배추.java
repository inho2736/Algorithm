
import java.util.*;
import java.io.*;
public class Boj1012_유기농배추 {
	static int [][] map;
	static boolean [][] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			map = new int [n][m];
			check = new boolean [n][m];
			for(int j=0; j<k; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				map[b][a] = 1;
			}
			int count = 0;
			for(int p=0; p<n; p++) {
				for(int j=0; j<m; j++) {
					if (map[p][j] == 1 && !check[p][j]) {
						bfs(n, m, p, j);
						count++;
					}
				}
			}
			bw.write(count+"\n");
			
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static void bfs(int n, int m, int a, int b) {
		Queue<int []> queue = new LinkedList<int []>();
		queue.offer(new int [] {a, b});
		check[a][b] = true;
		
		int [] dy = {1, 0, -1, 0};
		int [] dx = {0, 1, 0, -1};
		
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int y = tmp[0];
			int x = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpy = tmp[0] +dy[i];
				int tmpx = tmp[1] +dx[i];
				if(tmpx <0|| tmpy<0 || tmpy >= n || tmpx >= m) {
					continue;
				}
				if(map[tmpy][tmpx] == 1 && !check[tmpy][tmpx]) {
					queue.offer(new int [] {tmpy, tmpx});
					check[tmpy][tmpx] = true;
				}
				
			}
		}
		
		
	}

}

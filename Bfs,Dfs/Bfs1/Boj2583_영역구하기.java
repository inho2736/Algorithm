package Bfs1;
import java.util.*;
import java.io.*;

public class Boj2583_영역구하기 {
	static int [][] map;
	static boolean [][] check;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList <Integer> result = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int [m][n];
		check = new boolean [m][n];
		
		for(int i=0; i<k; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(tmp.nextToken());
			int sy = Integer.parseInt(tmp.nextToken());
			int ex = Integer.parseInt(tmp.nextToken());
			int ey = Integer.parseInt(tmp.nextToken());
			
			draw(sx, sy, ex, ey);
		}
		
		/*for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}*/
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0 && !check[i][j]) {
					result.add(bfs(i, j));
				}
			}
		}
		Collections.sort(result);
		bw.write(result.size() + "\n");
		for(int i : result) {
			bw.write(i + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	private static int bfs(int a, int b) {
		Queue<int []> queue = new LinkedList<int []>();
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		
		queue.add(new int [] {a, b});
		check[a][b] = true;
		int result = 1;
		
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= m || tmpy >= n) {
					continue;
				}
				
				if(map[tmpx][tmpy] == 0 && !check[tmpx][tmpy]) {
					queue.add(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
					result++;
				}
			}
		}
		return result;
	}
	
	
	
	
	private static void draw(int sx, int sy, int ex, int ey) {
		for(int i=sy; i<ey; i++) {
			for(int j=sx; j<ex; j++) {
				map[i][j] = 1;
			}
		}
	}

}

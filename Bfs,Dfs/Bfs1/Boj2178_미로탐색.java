package Bfs1;
import java.util.*;
import java.io.*;
public class Boj2178_미로탐색 {
	static int n;
	static int m;
	static int [][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int [n][m];
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		bfs(0,0);
		bw.write(arr[n-1][m-1]+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int a, int b) {
		boolean [][] check = new boolean [n][m];
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		Queue<int []> queue = new LinkedList<int []>();
		
		queue.offer(new int [] {a, b});
		check[a][b] = true;
		
		while(!queue.isEmpty()) {
			int [] tmp= queue.poll();
			int x = tmp[0];
			int y = tmp[1];
		
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				if(tmpx <0 || tmpy<0 || tmpx>=n || tmpy>=m) {
					continue;
				}
				if(arr[tmpx][tmpy] == 1 && (!check[tmpx][tmpy])) {
					queue.offer(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
					arr[tmpx][tmpy] = arr[x][y]+1;
				}
			}
		}
	}

}

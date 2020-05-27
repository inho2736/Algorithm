package Bfs1;
import java.util.*;
import java.io.*;
public class Boj2468_안전영역 {
	static int [][] arr;
	static boolean [][] check;
	static int n;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/////
		int max = 0;
		for(int i=0; i<100; i++) {
			
			int count = 0;
			check = new boolean [n][n];
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(arr[j][k] > i && !check[j][k]) {
						bfs(j, k, i);
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}
		bw.write(max+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
	private static void bfs(int j, int k, int height) {
		Queue <int []> queue = new LinkedList<int []>();
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		
		queue.offer(new int [] {j, k});
		check[j][k] = true;
		
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy>= n) {
					continue;
				}
				if(arr[tmpx][tmpy] > height && !check[tmpx][tmpy]) {
					queue.add(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
				}
			}
		}
		
	}

}

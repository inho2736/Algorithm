package Bfs1;
import java.util.*;
import java.io.*;
public class Boj11403_경로찾기 {
	static int [][] map;
	static int n;
	static int [][] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		result = new int [n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		for(int i=0; i<n; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					queue.add(j);
				}
			}
			bfs(i, queue);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	private static void bfs(int k, Queue<Integer> queue) {
		boolean [] check = new boolean [n];
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			check[tmp] = true;
			result[k][tmp] = 1;
			
			for(int i=0; i<n; i++) {
				if(map[tmp][i] == 1 && !check[i]) {
					queue.add(i);
				}
			}
			
		}
		
	}

}

package Bfs1;
import java.util.*;
import java.io.*;
public class Boj2667_단지번호붙이기 {
	static int n;
	static int [][] arr;
	static boolean [][] check;
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int [n][n];
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		check = new boolean[n][n];
		ArrayList <Integer> result = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 1 && check[i][j] == false) {
					result.add(bfs(i, j));
				}
			}
		}
		
		bw.write(result.size()+"\n");
		Collections.sort(result);
		for(int i : result) {
			bw.write(i+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static int bfs(int a, int b) {
		Queue<int []> queue = new LinkedList<int []>();
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		
		queue.offer(new int [] {a, b});
		check[a][b] = true;
		int result = 1;
		
		while(!queue.isEmpty()) {
			int tmp [] = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpx = x+dx[i];
				int tmpy = y+dy[i];
				
				if(tmpx <0 || tmpy <0 || tmpx >= n || tmpy >= n) {
					continue;
				}
				
				if(arr[tmpx][tmpy] == 1 && !check[tmpx][tmpy]) {
					queue.offer(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
					result++;
				}
			}
		}
		
		return result;
	}

}

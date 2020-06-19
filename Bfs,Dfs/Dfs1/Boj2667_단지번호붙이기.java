package Dfs1;
import java.util.*;
import java.io.*;
public class Boj2667_단지번호붙이기 {
	static int n;
	static int [][] arr;
	static boolean [][] check;
	static int count;
	static int [] dx = {0, 1, 0, -1};
	static int [] dy = {1, 0, -1, 0};
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
		count = 0;
		ArrayList <Integer> result = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 1 && check[i][j] == false) {
					result.add(dfs(i, j));
					count = 0;
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
	private static int dfs(int x, int y) {
		count++;
		
		check[x][y] = true;
		for(int i=0; i<4; i++) {
			int tmpx = x + dx[i];
			int tmpy = y + dy[i];
			
			if(tmpx<0 || tmpy < 0 || tmpx >= n || tmpy >= n) {
				continue;
			}
			if(arr[tmpx][tmpy] == 1 && !check[tmpx][tmpy]) {
				dfs(tmpx, tmpy);
			}
		}
		return count;
		
	}

}

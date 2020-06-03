package Bfs2;
import java.util.*;
import java.io.*;
public class Boj10026_적록색약 {
	static int n;
	static char [][] map;
	static boolean [][] check;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		map = new char [n][n];
		check = new boolean [n][n];
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<tmp.length(); j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		// 정상인 시야
		int normalCount = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j]) {
					normalBfs(i, j);
					normalCount++;
				}
			}
		}
		
		// 체크배열 초기화
		check = new boolean [n][n];
		
		// 적록색약인 시야
				int rgCount = 0;
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(!check[i][j]) {
							rgBfs(i, j);
							rgCount++;
						}
					}
				}
				
		
		// 임시출력
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				bw.write(map[i][j] + " ");
//			}
//			bw.write("\n");
//		}
		bw.write(normalCount+ " ");
		bw.write(rgCount+ "");
		br.close();
		bw.flush();
		bw.close();
	}

	private static void normalBfs(int a, int b) {
		Queue <int []> queue = new LinkedList<int []>();
		queue.offer(new int [] {a, b});
		check[a][b] = true;
		
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		
		char value = map[a][b];
		
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= n) {
					continue;
				}
				
				if(map[tmpx][tmpy] == value && !check[tmpx][tmpy]) {
					queue.add(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
				}
			}
		}
	}
	private static void rgBfs(int a, int b) {
		Queue <int []> queue = new LinkedList<int []>();
		queue.offer(new int [] {a, b});
		check[a][b] = true;
		
		int [] dx = {0, 1, 0, -1};
		int [] dy = {1, 0, -1, 0};
		
		boolean isRg = isRg(map[a][b]);
		
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int tmpx = x + dx[i];
				int tmpy = y + dy[i];
				
				if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= n) {
					continue;
				}
				
				if(isRg(map[tmpx][tmpy]) == isRg && !check[tmpx][tmpy]) {
					queue.add(new int [] {tmpx, tmpy});
					check[tmpx][tmpy] = true;
				}
			}
		}
	}
	private static boolean isRg(char a) {
		if (a == 'B') {
			return false;
		}
		else {
			return true;
		}
	}
	

}

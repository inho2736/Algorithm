package Bfs2;
import java.util.*;
import java.io.*;
public class Boj1707_이분그래프 {
	static int v;
	
	static ArrayList<Integer> [] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map = new ArrayList [v+1];
			for(int j=1; j<=v; j++) {
				map[j] = new ArrayList<Integer>();
			}
			for(int k=0; k<e; k++) {
				StringTokenizer tmp = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tmp.nextToken());
				int b = Integer.parseInt(tmp.nextToken());
				map[a].add(b);
				map[b].add(a);
			}
			boolean result = true;
			int [] check = new int[v+1];
			for(int k=1; k<=v; k++) {
				if(check[k] == 0) {
					if(!bfs(k, check)) {
						result = false;
						break;
					}
				}
			}
			if(result) {
				bw.write("YES\n");
			}
			else {
				bw.write("NO\n");
			}
		}
		
				
		br.close();
		bw.flush();
		bw.close();
	}
	private static boolean bfs(int a, int [] check) {
		boolean result = true;
		Queue <Integer> queue = new LinkedList<Integer>();
		
		queue.add(a);
		check[a] = 1;
		
		loop:
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			int color = check[tmp];
			for(int i : map[tmp]) {
				if(check[i] == 0) {
					check[i] = converse(color);
					queue.add(i);
				}
				else {
					if(check[i] == color) {
						result = false;
						break loop;
					}
				}
			}
		}
		return result;
	}
	private static int converse(int a) {
		if(a == 1) {
			return 2;
		}
		else {
			return 1;
		}
	}

}

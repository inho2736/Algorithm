import java.io.*;
import java.util.*;
public class Boj1260_Bfs와Dfs {
	static int n;
	static ArrayList<Integer> [] list;
	static boolean [] check;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(line.nextToken());
			int b = Integer.parseInt(line.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(list[i]);
		}
		check = new boolean[n+1];
		dfs(start);
		for(int i: result) {
			bw.write(i+" ");
		}
		bw.write("\n");
		check = new boolean[n+1];
		result = new ArrayList<Integer>();
		bfs(start);
		for(int i: result) {
			bw.write(i+" ");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	public static void dfs(int x) {

		check[x] = true;
		
		result.add(x);
		for(int y: list[x]) {
			if(!check[y]){
				dfs(y);
			}
		}
	}
	
	public static void bfs(int x) {
		Queue <Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		check[x] = true;
		
		while(!queue.isEmpty()) {
			int i = queue.poll();
			result.add(i);	
			for(int j:list[i]) {
				if(!check[j]) {
					check[j] = true;
					
					queue.add(j);
				}
			}
		}
	}

}

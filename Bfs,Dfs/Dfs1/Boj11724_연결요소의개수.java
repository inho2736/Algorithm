package Dfs1;
import java.io.*;
import java.util.*;

public class Boj11724_연결요소의개수 {

	static ArrayList<Integer> [] arr;
	static boolean [] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList [n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		check = new boolean [n+1];
		for(int i=0; i<m; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tmp.nextToken());
			int v = Integer.parseInt(tmp.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		
		int count = 0;
		for(int i=1; i<=n; i++) {
			if(!check[i]) {
				dfs(i);
				count++;
			}
		}
		bw.write(count+"\n");
		br.close();
		bw.flush();
		bw.close();

	}
	public static void dfs(int a) {
		check[a] = true;
		
		for(int i:arr[a]) {
			if(!check[i]) {
				dfs(i);
			}
		}
		
	}
}

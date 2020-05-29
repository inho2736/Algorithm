package Bfs1;
import java.util.*;
import java.io.*;
public class Boj6603_로또 {
	static int [] arr;
	static int n;
	static String str;
	static String total;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			total = "";
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			str = "";
			
			if(n == 0) {
				break;
			}
			arr = new int [n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//////////////////////
			
			for(int i=0; i<n; i++) {
				dfs(str + arr[i]+" ", i, 1);
			}
			
			bw.write(total +"\n");
			
		}
		br.close();
		bw.flush();
		bw.close();
	}
	private static void dfs(String str, int node, int cnt) {
		if(cnt == 6) {
			total += str + "\n";
		}
		else {
			cnt++;
			for(int i=node +1; i<n; i++) {				
				dfs(str + arr[i] + " ", i, cnt);
			}
		}
	}

}

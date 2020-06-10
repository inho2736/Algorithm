package Bfs2;
import java.util.*;
import java.io.*;
public class Boj1389_케빈베이컨의6단계법칙 {
	static int n;
	static int k;
	static ArrayList<Integer> [] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new ArrayList [n+1];
		for(int i=1; i<=n; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<k; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tmp.nextToken());
			int b = Integer.parseInt(tmp.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		
		///
		int min = 1000;
		int result = -1;
		for(int i=1; i<=n; i++) {
			int tmp = bfs(i);
			if(tmp < min) {
				min = tmp;
				result = i;
			}
		}
		
		bw.write(result+"\n");
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	private static int bfs(int start) {
		int result = 0;
		Queue <Integer> queue = new LinkedList<Integer>();
		int [] check = new int [n+1];
		queue.add(start);
		check[start] = 1;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			int value = check[tmp];
			for(int i : map[tmp]) {
				if(check[i] == 0) {
					queue.add(i);
					check[i] = value + 1;
					result += value;
				}
			}
		}
		
		return result;
	}
}

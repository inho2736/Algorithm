package Bfs1;
import java.util.*;
import java.io.*;
public class Boj1697_숨바꼭질 {
	static int [] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int [1000000];
		bw.write(bfs(n, k)-1+" ");
		br.close();
		bw.flush();
		bw.close();
	}
	public static int bfs(int n, int k) {
		
		if(n == k) {
			return 1;
		}
		Queue <Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		map[n] = 1;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			int [] arr = new int [3];
			int value = map[tmp];
			arr[0] = tmp + 1;
			arr[1] = tmp - 1;
			arr[2] = tmp * 2;
			
			
			
			for(int i=0; i<3; i++) {
				if(arr[i] <0 || arr[i] > 100000) {
					continue;
				}
				if(arr[i] == k) {
					return value+1;
				}
				
				if(map[arr[i]] == 0) {
					map[arr[i]] = value +1;
					queue.add(arr[i]);
				}
			}
			
			
		}
		return -1;
		
		
	}

}

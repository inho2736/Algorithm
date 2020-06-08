package Bfs2;
import java.util.*;
import java.io.*;
public class Boj2644_촌수계산 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int totalNode = Integer.parseInt(br.readLine());
		ArrayList<Integer> [] arr = new ArrayList [totalNode+1];
		for(int i=1; i<=totalNode; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(tmp.nextToken());
			int second = Integer.parseInt(tmp.nextToken());
			
			arr[first].add(second);
			arr[second].add(first);
		}
		int [] dist = new int [totalNode+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i : arr[a]) {
		
			queue.add(i);
			dist[i] = 1;
		}
		int result = -1;
		loop:
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			int value = dist[tmp];
			
			for(int i : arr[tmp]) {
				if(i == b) {
					result = value + 1;
					break loop;
				}
				if(dist[i] == 0) {
					queue.add(i);
					dist[i] = value + 1;
				}
			}
		}
		bw.write(result+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}

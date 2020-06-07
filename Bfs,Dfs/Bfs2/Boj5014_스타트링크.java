package Bfs2;
import java.util.*;
import java.io.*;
public class Boj5014_스타트링크 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int total = Integer.parseInt(st.nextToken());
		int now = Integer.parseInt(st.nextToken());
		int desti = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		
		int [] check = new int [total+1];
		int result = -1;
		Queue <Integer> queue = new LinkedList<Integer>();
		queue.add(now);
		check[now] = 1;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			int value = check[tmp];
			
			if(tmp == desti) {
				result = value;
			}
			int next1 = tmp + up;
			int next2 = tmp - down;
			
			
			
			if(next1 <= total && next1 >= 1 &&check[next1] == 0) {
				queue.add(next1);
				check[next1] = value + 1;
			}
			if(next2 >= 1 && next2 <= total && check[next2] == 0) {
				queue.add(next2);
				check[next2] = value + 1;
			}
		}
		if(result == -1) {
			bw.write("use the stairs\n");
		}
		else if(now == desti){
			
			bw.write(0+"\n");
		}
		else {
			bw.write(result-1+"\n");

		}
		br.close();
		bw.flush();
		bw.close();
	}

}

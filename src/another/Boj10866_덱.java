package another;
import java.io.*;
import java.util.*;
public class Boj10866_덱 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		 Deque<Integer> deque = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		
		int front_value = -1;
		int back_value = -1;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
			}
			else if (cmd.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
			}
			else if (cmd.equals("pop_front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.pollFirst());
				}
			}
			else if (cmd.equals("pop_back")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.pollLast());
				}
			}
			else if (cmd.equals("size")) {
				System.out.println(deque.size());
			}
			else if (cmd.equals("empty")) {
				if(deque.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if (cmd.equals("front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.getFirst());
				}
			}
			else if (cmd.equals("back")) {
				if(deque.isEmpty() ) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.getLast());
				}
			}
			
		}
		br.close();
		bw.close();
	}

}

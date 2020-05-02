package another;
import java.io.*;
import java.util.*;
public class Boj10845_큐 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> queue = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		int bf_value = -1;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				bf_value = num;
				queue.add(num);
			}
			else if (cmd.equals("pop")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(queue.poll());
				}
			}
			else if (cmd.equals("size")) {
				System.out.println(queue.size());
			}
			else if (cmd.equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if (cmd.equals("front")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(queue.peek());
				}
			}
			else if (cmd.equals("back")) {
				if(queue.isEmpty() ) {
					System.out.println(-1);
				}
				else {
					System.out.println(bf_value);
				}
			}
			
		}
		br.close();
		bw.close();
	}

}

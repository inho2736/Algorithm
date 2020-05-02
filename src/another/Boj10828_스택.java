package another;
import java.io.*;
import java.util.*;
public class Boj10828_스택 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				int k = Integer.parseInt(st.nextToken());
				stack.push(k);
			}
			else if(cmd.equals("pop")) {
				if(stack.isEmpty()) {
					bw.write(-1+ "\n");
				}
				else {
					bw.write(stack.pop()+ "\n");
				}
			}
			else if(cmd.equals("size")) {
				bw.write(stack.size()+ "\n");
			}
			else if(cmd.equals("empty")) {
				if(stack.isEmpty()) {
					bw.write(1+ "\n");
				}
				else {
					bw.write(0+ "\n");
				}
			}
			else if(cmd.equals("top")) {
				if(stack.isEmpty()) {
					bw.write(-1+ "\n");
				}
				else {
					bw.write(stack.peek()+ "\n");
				}
			}
		}
		bw.flush();
		br.close();
		bw.close();
		
		
	}

}

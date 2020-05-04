package another;
import java.io.*;
import java.util.*;
public class Boj1406_에디터 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String st = br.readLine();
		
		Deque<Character> stack1 = new ArrayDeque<>();
		Stack<Character> stack2 = new Stack<>();
		
		for(int i=0; i<st.length(); i++) {
			stack1.addLast(st.charAt(i));
		}
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			StringTokenizer cmdLine = new StringTokenizer(br.readLine());
			String cmd = cmdLine.nextToken();
			if(cmd.equals("L")) {
				if(stack1.isEmpty()) {
					continue;
				}
				else {
					char tmp = stack1.pollLast();
					stack2.push(tmp);
				}
			}
			else if(cmd.equals("D")) {
				if(stack2.isEmpty()) {
					continue;
				}
				else {
					char tmp = stack2.pop();
					stack1.addLast(tmp);
				}
			}
			else if(cmd.equals("B")) {
				if(stack1.isEmpty()) {
					continue;
				}
				else {
					stack1.pollLast();
				}
			}
			else if(cmd.equals("P")) {
				String next = cmdLine.nextToken();
				stack1.addLast(next.charAt(0));
			}
		}
		int size1 = stack1.size();
		int size2 = stack2.size();
		for(int i=0; i<size1; i++) {
			bw.write(stack1.pollFirst());
		}
		for(int i=0; i<size2; i++) {
			bw.write(stack2.pop());
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}

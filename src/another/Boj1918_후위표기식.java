package another;
import java.util.*;
import java.io.*;
public class Boj1918_후위표기식 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<Character>();
		
		String st = br.readLine();
		for(int i=0; i<st.length(); i++) {
			char tmp = st.charAt(i);
			switch(tmp){
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(tmp)) {
					bw.write(stack.pop());
				}
				stack.push(tmp);
				break;
			case '(':
				stack.push(tmp);
				break;
			
			case ')':
				while(!stack.isEmpty() && stack.peek() != '(' ) {
					bw.write(stack.pop());
				}
				stack.pop();
				break;
			default:
				bw.write(tmp);
			}
		}
		while (!stack.isEmpty()) {
	        bw.write(stack.pop());
	    }


	
		br.close();bw.flush();bw.close();
	}
	private static int priority(char a) {
		switch(a) {
		case '(':
		case ')':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}

}

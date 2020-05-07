package another;
import java.util.*;
import java.io.*;
public class Boj1918_후위표기식 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<Character>();
		
		String st = br.readLine();
		for(int i=0; i<st.length(); i++) {
			char tmp = st.charAt(i);
			if(tmp >= 'A' && tmp <= 'Z') {
				bw.write(tmp);
			}
			else if(tmp == '+' || tmp == '-' || tmp == '/' || tmp == '*') {
				stack.push(tmp);
			}
			else if(tmp == ')') {
				bw.write(stack.pop());
			}
		}
		while(!stack.isEmpty()) {
			bw.write(stack.pop());
		}
		br.close();bw.flush();bw.close();
	}

}

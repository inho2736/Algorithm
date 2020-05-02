package another;
import java.io.*;
import java.util.*;
public class Boj10799_쇠막대기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<Integer>();
		String st = br.readLine();
		char bf_c = 0;
		int result= 0;
		for(int i=0; i<st.length(); i++) {
			char c = st.charAt(i);
			if(c == '(') {
				stack.push(1);
				bf_c = c;
			}
			else if( c == ')') {
				if(bf_c == '(') {
					stack.pop();
					result += (stack.size());
				}
				else {
					stack.pop();
					result += 1;
				}
				bf_c = c;
			}
		}
		br.close();
		bw.close();
		System.out.println(result);
	}

}

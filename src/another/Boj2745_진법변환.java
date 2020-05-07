package another;
import java.io.*;
import java.util.*;

public class Boj2745_진법변환 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack <Character> stack = new Stack <Character>();
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());	
		for(int i=0; i<n.length(); i++) {
			stack.push(n.charAt(i));
		}
		int result = 0;
		int tmp_b = 1;
		
		while(!stack.isEmpty()) {
			int tmp = change(stack.pop());
			result += tmp * tmp_b;
			tmp_b *= b;
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
	public static int change(char a) {
		if(a>= '0' && a<= '9') {
			
			return a - '0';
		}
		else {
			return a - 'A' + 10;
		}
			
	}

}

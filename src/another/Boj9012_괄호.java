package another;
import java.io.*;
import java.util.*;
public class Boj9012_괄호 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		boolean flag = false;
		for(int i=0; i<n; i++) {
			String st = br.readLine();
			Stack<Integer> stack = new Stack<Integer>();
			for(int j=0; j<st.length(); j++) {
				char c = st.charAt(j);
				if(c == '(') {
					stack.push(1);
				}
				else {
					if(stack.isEmpty()) {
						flag = true;
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			if(flag) {
				bw.write("NO\n" );
			}
			else if (stack.isEmpty()) {
				bw.write("YES\n" );
			}
			else {
				bw.write("NO\n" );
			}
			flag = false;
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}

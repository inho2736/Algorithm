package another;
import java.io.*;
import java.util.*;
public class Boj1212_8진수2진수 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack <Integer> stack = new Stack<Integer>();
		String st = br.readLine();
		
		for(int i=st.length()-1; i>=0; i--) {
			
			int tmp = st.charAt(i) - '0';
			if(tmp%2 == 1) {
				stack.push(1);
			}
			else {
				stack.push(0);
			}
			tmp = (int)(tmp/2);
			
			if(tmp%2 == 1) {
				stack.push(1);
			}
			else {
				stack.push(0);
			}
			tmp = (int)(tmp/2);
			if(tmp == 1) {
				stack.push(1);
			}
			else {
				stack.push(0);
			}
		}
		boolean flag = false;
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			if(tmp == 1) {
				flag = true;
			}
			if(flag) {
				bw.write(tmp+"");
			}
		}
		if(flag == false) {
			bw.write(0+"");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}

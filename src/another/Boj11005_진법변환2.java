package another;
import java.io.*;
import java.util.*;
public class Boj11005_진법변환2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack <Integer> stack = new Stack <Integer>();
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int tmp_b = b;
		while(n>0) {
			stack.push(n % tmp_b);
			n =  n / tmp_b;
		}
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			if(tmp >= 10) {
				bw.write(tmp -10 + 'A');
			}
			else {
				bw.write(tmp+"");
			}
			
		}
		br.close();
		bw.flush();
		bw.close();
	
	}

}

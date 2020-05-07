package another;
import java.io.*;
import java.util.*;
public class Boj11576_BaseConversion {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int num = Integer.parseInt(br.readLine());
		
		Stack <Integer> stack = new Stack<Integer>();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<num; i++) {
			stack.push(Integer.parseInt(st2.nextToken()));
		}
		
		int result = 0;
		int tmp = 1;
		
		while(!stack.isEmpty()) {
			result += stack.pop() * tmp;
			tmp *= a;
		}
		//
		if(result == 0) {
			bw.write(0+"");
			bw.flush();
			br.close();
			bw.close();
			return;
		}
		while(result > 0) {
			stack.push(result % b);
			result = (int)(result / b);
		}
		
		while(!stack.isEmpty()) {
			bw.write(stack.pop()+" ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	

}

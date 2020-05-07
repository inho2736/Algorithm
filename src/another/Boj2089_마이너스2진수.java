package another;
import java.io.*;
import java.util.*;
public class Boj2089_마이너스2진수{

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		double st = Double.parseDouble(br.readLine());
		Stack <Integer> stack = new Stack<Integer>();
		if(st == 0) {
			bw.write(0+"");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		while(st != 0) {
			double n = (double) Math.ceil(st / -2);
			int remain = (int) (st - (n*-2));
			stack.push(remain);
			st = (int) n;
		}
		while(!stack.isEmpty()) {
			bw.write(stack.pop()+"");
		}
		bw.flush();
		bw.close();
		br.close();
	
	}

}

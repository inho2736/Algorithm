	package another;
	import java.io.*;
	import java.util.*;
	public class Boj1373_2진수8진수 {
	
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			Stack <Character> stack = new Stack<Character>();
			Stack <Integer> answer = new Stack<Integer>();
			String st = br.readLine();
			for(int i=0; i<st.length(); i++) {
				stack.push(st.charAt(i));
			}
			int tmp = 1;
			int num = 0;
			int i=0; 
			while(!stack.isEmpty()) {
				if(stack.pop().equals('1')){
					num += tmp;
				}
				tmp *= 2;
				i++;
				if(i == 3 || stack.isEmpty()) {
					answer.push(num);
					num = 0;
					tmp = 1;
					i=0;
				}
			}
			while(!answer.isEmpty()) {
				bw.write(answer.pop()+"");
			}
			br.close();
			bw.flush();
			bw.close();
			
		}
	
	}

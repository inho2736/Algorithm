package another;
import java.io.*;
import java.util.*;
public class Boj1158_요세푸스문제 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		Deque<Integer> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] arr = new int [n+1];
		for(int i=1; i<=n; i++) {
			deque.addLast(i);
		}
		
		for(int i=1; i<=n; i++) {
			int tmp = k;
			while(tmp > 1) {
				int num = deque.pollFirst();
				deque.addLast(num);
				tmp--;
			}
			arr[i] = deque.pollFirst();
		}
		bw.write("<");
		for(int i=1; i<=n; i++) {
			if(i == n) {
				bw.write(arr[i]+"");
			}
			else {
				bw.write(arr[i]+", ");
			}
		}
		bw.write(">");
		bw.flush();
		bw.close();
		br.close();
	}

}

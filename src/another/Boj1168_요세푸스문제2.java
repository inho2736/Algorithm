package another;
import java.io.*;
import java.util.*;
public class Boj1168_요세푸스문제2 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken())-1;
		ArrayList<Integer> list = new ArrayList<Integer>();

		
		//int [] arr2 = new int [n+1];
		
		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		int index = 0;
		bw.write("<");
		while(true) { 
			index += k; 
			if (index >= list.size()) {
				index %= list.size(); 
			} 
			bw.write(list.remove(index)+""); 
			if(list.isEmpty()) {
				break;
			}
			else {
				bw.write(", ");
			}
		}
		bw.write(">");
		bw.flush();
		bw.close();
		br.close();

		
		
	
	}

}

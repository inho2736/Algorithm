package another;
import java.util.*;
import java.io.*;
public class Boj1929_소수구하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int [] arr = new int [1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		for(int i=2; i<=1000000; i++) {
			arr[i] = i;
		}
		
		for(int i=2; i<=Math.sqrt(1000000); i++) {
			if(arr[i] == 0) {
				continue;
			}
			for(int j=i+i; j<=1000000; j+=i) {
				arr[j] = 0;
			}
		}
		
		for(int i=m; i<=n; i++) {
			if(arr[i] > 0) {
				bw.write(i+"\n");
			}
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}

}

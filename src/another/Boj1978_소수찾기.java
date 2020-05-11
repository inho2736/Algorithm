package another;
import java.util.*;
import java.io.*;
public class Boj1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int [] arr = new int [1001];
		
		for(int i=2; i<=1000; i++) {
			arr[i] = i;
		}
		
		for(int i=2; i <= Math.sqrt(1000); i++ ) {
			if( arr[i] == 0) {
				continue;
			}
			for(int j = i+i; j<=1000; j+=i) {
				arr[j] = 0;
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(arr[tmp] > 0) {
				result++;
			}
		}
		
//		for(int i=1; i<=10; i++) {
//			bw.write(arr[i]+" ");
//		}
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}

}

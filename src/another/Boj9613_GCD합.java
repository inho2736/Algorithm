package another;
import java.util.*;
import java.io.*;
public class Boj9613_GCD합 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int [] arr = new int [m];	
			long sum = 0;
			for(int j=0; j<m; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=0; j<m-1; j++) {
				for(int k = j+1; k<m; k++) {
					int a = arr[j];
					int b = arr[k];
					sum += getGcd(Math.max(a, b), Math.min(a,b));
				}
			}
			bw.write(sum+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static long getGcd(long a, long b) {
		while(b>0) {
			long tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}

}

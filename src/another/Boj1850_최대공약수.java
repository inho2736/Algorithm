package another;
import java.util.*;
import java.io.*;
public class Boj1850_최대공약수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long num = getGcd(Math.max(a, b), Math.min(a, b));
		for(long i=0; i<num; i++) {
			bw.write("1");
		}
		
		bw.flush();
		bw.close();
		br.close();
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

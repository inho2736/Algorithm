package another;
import java.util.*;
import java.io.*;
public class Boj2004_조합0의개수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		
		long count5 = count5(n) - count5(m) - count5(n-m);
		long count2 = count2(n) - count2(m) - count2(n-m);
		
		bw.write(Math.min(count5, count2)+"");
		bw.flush();
		br.close();
		bw.close();
	}
	public static long count5(long num) {
		long count = 0;
		for(long i= 5; i<=num; i*=5) {
			count += num /i;
		}
		return count;
	}
	public static long count2(long num) {
		long count = 0;
		for(long i= 2; i<=num; i*=2) {
			count += num / i;
		}
		return count;
	}
}

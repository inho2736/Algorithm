package another;
import java.util.*;
import java.io.*;
public class Boj2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int gcd, lcm;
		gcd = GetGCD(Math.max(n, m), Math.min(n, m));
		lcm = n*m/gcd;
		
		bw.write(gcd+"\n");
		bw.write(lcm+"");
		br.close();
		bw.flush();
		bw.close();
	}
	public static int GetGCD(int a, int b) {
		while(b > 0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}

}

package another;
import java.util.*;
import java.io.*;
public class Boj1934_최소공배수 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(getLcm(a, b)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int getLcm(int a, int b) {
		int mul = a*b;
		while(b>0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return mul/a;
	}

}

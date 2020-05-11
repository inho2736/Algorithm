package another;
import java.util.*;
import java.io.*;
public class Boj10872_팩토리얼 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		bw.write(result +"");
		bw.flush();
		br.close();
		bw.close();
		
	}

}

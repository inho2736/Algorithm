package another;
import java.util.*;
import java.io.*;
public class Boj1676_팩토리얼0의개수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		  
		int count5 = 0;
		int result = 1;
		for(int i=1; i<=n; i++) {
			int tmp = i;
			while(tmp % 5 == 0) {
				count5++;
				tmp /= 5;
			}
			/*if(i % 5 == 0) {
				count5++;
			}*/
		}
		bw.write(count5 +"");
		bw.flush();
		br.close();
		bw.close();
	}
}

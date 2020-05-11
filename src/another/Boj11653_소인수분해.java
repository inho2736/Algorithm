package another;
import java.util.*;
import java.io.*;
public class Boj11653_소인수분해 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int [] arr = new int [10000001];
		for(int i=2; i<10000001; i++) {
			arr[i] = 1;
		}
		
		for(int i=2; i<Math.sqrt(10000001); i++) {
			if(arr[i] == 0) {
				continue;
			}
			for(int j=i+i; j<10000001; j+=i) {
				arr[j] = 0;
			}
		}
		
		
		int n = Integer.parseInt(br.readLine());
		int div = 2;
		//1일때는 아무것도 출력하지 않아야한다.
		if(n == 1) {
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		while(arr[n] == 0) {
			if(n % div == 0) {
				n = n/div;
				bw.write(div+"\n");
			}
			
			else {
				while(true) {
					div++;
					if((arr[div] >0) && (n%div == 0)) {
						break;
					}
				}
			}
		}
		bw.write(n + "\n");
		
		
		bw.flush();
		br.close();
		bw.close();
	}

}

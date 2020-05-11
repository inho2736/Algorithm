package another;
import java.util.*;
import java.io.*;
public class Boj6588_골드바흐의추측 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int [] arr = new int [1000001];
		for(int i=2; i<1000001; i++) {
			arr[i] = 1;
		}
		
		for(int i=2; i<Math.sqrt(1000001); i++) {
			if(arr[i] == 0) {
				continue;
			}
			for(int j=i+i; j<1000001; j+=i) {
				arr[j] = 0;
			}
		}
		
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				break;
			}
			else {
				boolean flag = false;
				for(int i=3; i<=n-3; i++) {
					if(arr[i] > 0 && arr[n-i] > 0) {
						bw.write(n + " = " + i + " + " + (n-i) +"\n");
						flag = true;
						break;
					}
				}
				if(flag == false) {
					bw.write("Goldbach's conjecture is wrong.");
				}
			}
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}

}

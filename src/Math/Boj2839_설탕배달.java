package Math;
import java.util.*;
import java.io.*;
public class Boj2839_설탕배달 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		if(n % 5 == 0) {
			result = n/5;
		}
		else {
			result = n / 5;
			int tmp = n % 5;
			while(true) {
				
				if(tmp % 3 == 0) {
					result += tmp/3;
					break;
				}
				else {
					if(tmp == n) {
						result = -1;
						break;
					}
					result--;
					tmp += 5;
				}
			}
		}
		
		// 5로 나눠떨어지면 그게 최선
		
		// 안나눠떨어지면 나머지를 3으로 나눠떨어지면 그게 최선
		
		// 3으로 안나눠떨어지면 5한개씩 풀면서 3으로 나눠떨어지는지 확인
		
		bw.write(result+"\n");
		br.close();
		bw.flush();
		bw.close();
		
	}
	
}

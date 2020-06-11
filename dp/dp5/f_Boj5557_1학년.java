// 시간초과가 난다.
package dp5;
import java.util.*;
import java.io.*;
public class f_Boj5557_1학년 {
	static int [] arr;
	static int n;
	static String answer = "";
	static long result=0;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, arr[0]/*, "8"*/);
		
		//bw.write(answer + "\n");
		bw.write(result+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int count, int sum/*, String st*/) {
		//count가 다 차면 최종값이 맞는지 확인
		if(count == n-1) {
			if(sum == arr[n-1]) {
				/*answer += st + "\n";*/
				result++;
			}
			return;
		}
		else if(sum < 0 || sum > 20){
			return;
		}
		else {
			dfs(count+1, sum+arr[count]/*, st + " + " + arr[count]*/);
			dfs(count+1, sum-arr[count]/*, st + " - " + arr[count]*/);
		}
	}

}

package dp2;
import java.util.*;
public class inho_Boj1912 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		//데이터 받을 배열
		int [] arr = new int[num];
		//dp배열
		//dp[i] 를 i 번째 수를 마지막으로 가지는 연속수의 합의 최댓값 이라고 가정해야 문제를  풀 수 있다.
		int [] dp = new int[num];
		
		//데이터 받기
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
		}
		
		//0번째 수가 마지막인 연속수는 0번째 수 하나로만 이루어짐. 따라서 그냥 0번째 수를 넣는다.
		dp[0] = arr[0];
		
		int max = dp[0];
		//내 직전에서의 dp 값이 음수가 아니면 더해야 최댓값을 구할 수 있다.
		for(int i=1; i<num; i++) {
			if(dp[i-1] > 0) {
				dp[i] = dp[i-1] + arr[i];
			}
			//직전 dp가 음수면 끊어내고 나 자신이 제일 큰거임.
			else {
				dp[i] = arr[i];
			}
			//dp구할때마다 최댓값 갱신여부 확인
			if(dp[i]> max) {
				max = dp[i];
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(max);
	}

}

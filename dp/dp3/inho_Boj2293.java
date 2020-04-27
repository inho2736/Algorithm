package dp3;
import java.util.*;
public class inho_Boj2293 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//동전 종류의 개수 n
		int n = sc.nextInt();
		
		//최종 합 k원
		int k = sc.nextInt();
		
		//동전 종류 저장할 배열 (coin = {1, 2, 5})
		int coin [] = new int [n];
		for(int i=0; i<n; i++) {
			coin[i] = sc.nextInt();
		}
		//dp[n] 은 n원 을 만들 수 있는 동전의 가지수
		int dp[] = new int [k+1];
		
		//dp[i - i] 의 경우 dp[0]이 됨.
		//5를 만드는데 5원짜리 동전을 사용할 경우 이므로 1가지 수를 추가해야하므로 dp[0]은 1로 초기화
		dp[0] = 1;
		
		//동전 1부터 시작해서 i = 1, 2, 5순으로 변경
		for(int i=0; i<n; i++) {
			//j = 나타낼 합의 가치 
			//동전 5일 경우 5보다 작은 합은 나타낼 수 없음 
			//그러므로 j는 동전의 가치부터 시작해서 최종 원하는 합의 가치(k)까지
			//즉 위에서 말했듯이 dp[j]는 j원을 나타낼 수 있는 가지수이고
			//동전 1을 지날때는 1원으로 나타내는 가지수, 2를 지날때는 1원으로 나타내는 가지수 + 2원으로 나타내는 가지수
			for(int j=coin[i]; j<=k; j++) {
				dp[j] += dp[j - coin[i]] ;
			}
		}
		
			
		System.out.println(dp[k]);
		
	}

}

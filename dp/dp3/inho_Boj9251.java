package dp3;
import java.util.*;
public class inho_Boj9251 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		int len_s1 = s1.length();
		int len_s2 = s2.length();
		
		char [] arr1 = new char [len_s1+1];
		char [] arr2 = new char [len_s2+1];
		for(int i=1; i<=len_s1; i++) {
			
			arr1[i] = s1.charAt(i-1);
		}
		for(int i=1; i<=len_s2; i++) {
			
			arr2[i] = s2.charAt(i-1);
		}
		//System.out.println(Arrays.toString(arr1));
		int result=0;
		int dp[][] = new int[len_s1+1][len_s2+1];
		for(int i=1; i<=len_s1; i++) {
			int max = 1;
			for(int j=1; j<=len_s2; j++) {
				
				if(arr1[i] == arr2[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
		}
		int max = 0;
		for(int j=1; j<=len_s2; j++) {
			max = Math.max(max, dp[len_s1][j]);
		}
		System.out.println(max);
		
		
		
	}

}

package dp4;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class inho_Boj10942 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 int n = Integer.parseInt(br.readLine());
		 //System.out.println(n);
	     int []arr = new int[n];
	     int [][] dp = new int[n][n];
	     
	    StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            //System.out.print(arr[i]);
        }
        
        for(int i=0; i<n; i++) {
			dp[i][i] = 1;
		}
		
		for(int i=1; i<n; i++) {
			if(arr[i-1] == arr[i]) {
				dp[i-1][i] = 1;
			}
		}
		
		for(int i=2; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				if((dp[j+1][j+i-1] == 1) && (arr[j] == arr[j+i])) {
					dp[j][j+i] = 1;
				}
			}
		}
		
		int m = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start-1][end-1]+"\n");
        }
        System.out.println(sb);
		////
        
        
        
		
		
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

}

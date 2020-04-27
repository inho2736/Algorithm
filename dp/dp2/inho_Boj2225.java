package dp2;
import java.util.*;
public class inho_Boj2225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int arr[][] = new int [k+1][n+1];
		
		for(int i=1; i<k+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == 1) {
					arr[i][j] = 1;
				}
				else if(j == 1){
					arr[i][j] = i;
				}
				else {
					arr[i][j] = (arr[i-1][j] + arr[i][j-1])%1000000000;
				}
			}
		}
		System.out.println(arr[k][n]);
	}

}

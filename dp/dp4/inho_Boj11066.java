package dp4;
import java.util.Scanner;
public class inho_Boj11066 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int [] sum = new int [num+1];
		int [] arr = new int [num+1];
		int [][] dp = new int [num+1][num+1];
		
		for(int i=1; i<=num; i++) {
			arr[i] = sc.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=i; j++) {
				
			}
		}
		
		
		
	}

}

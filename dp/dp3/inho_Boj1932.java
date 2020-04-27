package dp3;
import java.util.*;
public class inho_Boj1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		//int [] dp = new int [num+1];
		int [][] arr = new int [num+1][num+1];
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
//		for(int i=1; i<=num; i++) {
//			
//			System.out.println(Arrays.toString(arr[i]));
//		}
		int max = 0;
		for(int i=2; i<=num; i++) {
			for(int j=1; j<=i; j++) {
				
				if(j == 1) {
					arr[i][j] += arr[i-1][j];
				}
				else if(j == i){
					arr[i][j] += arr[i-1][j-1];
				}
				else {
					arr[i][j] += Math.max( arr[i-1][j-1], arr[i-1][j]);
				}
				
				if(i == num && arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}
		System.out.println(max);
	}

}

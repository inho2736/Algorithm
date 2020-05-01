package dp1;
//import java.util.Arrays;
import java.util.Scanner;

public class Boj9095 {

	public static int cal(int num) {
		int result;
			
		int[] arr = new int[num+1];
		if (num == 1) {
			result = 1;
		}
		else if(num ==2) {
			result = 2;
		}
		else if(num ==3) {
			result = 4;
		}
		else {
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;

			for (int i=4; i < num + 1; i++) {
				arr[i] = arr[i-2] + arr[i-1] +arr[i-3];
			}
			result = arr[num];
		}		
		return result;
		
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();		
		
		for(int i=0; i<num; i++) {
			int tmp = sc.nextInt();
			int result = cal(tmp);
			System.out.println(result);
		}
		
		sc.close();
	}
}
	

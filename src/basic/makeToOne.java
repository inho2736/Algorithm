package basic;
import java.util.Scanner;
import java.util.Arrays;
	
public class makeToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();		
		int tmp;
		int[] arr = new int[num+1];
		if (num == 1) {
			
			System.out.println(0);
			return;
		}
		
		//2  3   4(2)          5(3)       6(3)       7(4)     8(3)      9(2)      10(3)  
		//1  1  [2], [3]      [4]     [2][3][5]     [6]     [4][7]    [3][8]     [5][9]            
		//       1    1        2       1  1  3       3       2  4      1  3       3  2
		for (int i=1; i<num+1; i++) {
			if (i == 2 || i == 3) {
				arr[i] = 1;
				continue;
			}			
			arr[i] = arr[i-1]+1;
			tmp = arr[i];
			if (i % 2 == 0 && (tmp > arr[i/2] + 1)) {
				arr[i] = arr[i/2] + 1;			
			}
			if (i % 3 == 0 && (tmp > arr[i/3] + 1)) {
				arr[i] = arr[i/3] + 1;
			}
								
		}
		//System.out.println(Arrays.toString(arr));		
		System.out.println(arr[num]);
		sc.close();
		
	}

}

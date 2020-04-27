package dynamicProgramming;
import java.util.Scanner;
public class Boj9465 {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int [] arr= new int[number];
		
		for (int k=0; k<number; k++) {
			int num = sc.nextInt();
			
			int [][] d = new int[2][num];
			
			for(int i=0; i<2; i++) {
				for(int j=0; j<num; j++) {
					d[i][j] = sc.nextInt();
				}
			}
			d[0][1] += d[1][0];
			d[1][1] += d[0][0];
			for (int i=2; i<num; i++) {
				if(d[1][i-2] > d[1][i-1]) {
					d[0][i] += d[1][i-2];
				}
				else {
					d[0][i] += d[1][i-1];
				}
				if(d[0][i-2] > d[0][i-1]) {
					d[1][i] += d[0][i-2];
				}
				else {
					d[1][i] += d[0][i-1];
				}
			}
			
			if (d[0][num-1] >d[1][num-1]) {
				arr[k] =  d[0][num-1];
			}
			else {
				arr[k] =  d[1][num-1];		
			}
			System.out.println(arr[k]);	
		}
		
	}

}

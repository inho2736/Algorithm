package dp4;
import java.util.*;
public class inho_Boj2096 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int dp_max[][] = new int [num][3];
		int dp_min[][] = new int [num][3];
		int arr[][] = new int [num][3];
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<3; i++) {
			dp_max[0][i] = arr[0][i];
			dp_min[0][i] = arr[0][i];
		}
		for(int i=1; i<num; i++) {
			for(int j=0; j<3; j++) {
				if(j == 0) {
					dp_max[i][j] = Math.max(dp_max[i-1][0], dp_max[i-1][1]) + arr[i][j];
					dp_min[i][j] = Math.min(dp_min[i-1][0], dp_min[i-1][1]) + arr[i][j];
				}
				else if(j == 1) {
					dp_max[i][j] = Math.max(dp_max[i-1][0], dp_max[i-1][1]);
					dp_max[i][j] = Math.max(dp_max[i][j], dp_max[i-1][2]) + arr[i][j];
					
					dp_min[i][j] = Math.min(dp_min[i-1][0], dp_min[i-1][1]);
					dp_min[i][j] = Math.min(dp_min[i][j], dp_min[i-1][2]) + arr[i][j];
				}else if(j == 2) {
					dp_max[i][j] = Math.max(dp_max[i-1][1], dp_max[i-1][2]) + arr[i][j];
					dp_min[i][j] = Math.min(dp_min[i-1][1], dp_min[i-1][2]) + arr[i][j];
				}
			}
		}
		int max = 0;
		int min = 900000;
		
		for(int i=0; i<3; i++) {
			max = Math.max(dp_max[num-1][i], max);
			min = Math.min(dp_min[num-1][i], min);
		}
		System.out.print(max + " ");
		System.out.println(min);
	}

}

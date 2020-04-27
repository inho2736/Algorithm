package dp2;
import java.util.Scanner;
import java.util.Arrays;

public class inho_Boj11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		//arr 데이터 입력받을 배열
		int [] arr = new int [num];
		
		//정방향으로 증가하는 가장 긴 부분 수열의 길이를 저장
		int [] up = new int [num];
		
		//역방향으로 증가하는 가장 긴 부분의 수열의 길이를 저장
		int [] down = new int [num];
		
		//수열 길이 저장 배열은 모두 1로 초기화
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
			up[i] = 1;
			down[i] = 1;
		}
		
		//증가하는 가장 긴 부분 수열의 길이 저장
		//1부터
		for(int i=0; i<num; i++) {
			for(int j= 0; j<i; j++) {
				if (arr[j] < arr[i] && up[j]+1 > up[i]) {
					up[i] = up[j]+1;
				}
			}
		}
		
		//역방향으로 증가하는 가장 긴 부분의 수열의 길이 저장
		for(int i=num-1; i>=0; i--) {
			for(int j=num-1; j>i; j--) {
				if ( arr[i] > arr[j] && down[j]+1 > down[i]) {
					down[i] = down[j]+1;
				}
			}
		}
		
		//i  = 0 ~ num 에서  up[i] + down[i] 가 최대인 값을 찾는다.
		int max = 0;
		for(int i=0; i<num; i++) {
			int tmp = up[i] + down[i];
			if(tmp > max) {
				max = tmp;
			}
		}
	System.out.println(Arrays.toString(up));
	System.out.println(Arrays.toString(down));
	System.out.println(max-1);
		
		
	}

}

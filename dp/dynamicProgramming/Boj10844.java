package dynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

public class Boj10844 {

	public static void main(String[] args) {
		//num을 받으면
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();		
		
		//num * 10만큼 이차원 배열 선언
		// 자바도 배열 처음선언하면 전부 0으로 초기화됨
		int[][] arr = new int[num+1][10];
		
		//2차원 배열 프린트하려면 이렇게 일일히 해야함ㅠ
//		for(int i= 0; i< num; i++) {
//			for (int j = 0; j< 10; j++) {
//				System.out.print(arr[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println("");
//		}
		
		//1행 전부 1로 초기화하기
		for ( int i=0; i<10; i++) {
			arr[1][i] = 1;
		}
		
		for (int i=2; i<num+1; i++) {
			for(int j=9; j>=0; j--) {
				if(j == 0) {
					arr[i][j] = arr[i-1][j+1] % 1000000000;
				}
				else if(j == 9) {
					arr[i][j] = arr[i-1][j-1] % 1000000000;
				}
				else {
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;
				}
			}
		}
		//long형으로 해야 함 크기가 크니까
		long sum = 0;
		for (int i=1; i<10; i++) {
			sum += arr[num][i];
		}
		System.out.println(sum);

		sc.close();
	}
}
	

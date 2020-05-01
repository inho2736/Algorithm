import java.io.*;
public class SelectionSort {
	private static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1};

	public static void main(String[] args) {
		selectionSort(arr, arr.length);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void selectionSort(int [] arr, int n) {
		
		 // 교환을 위한 임시변수, 각 루프별 최댓값의 인덱스를 저장하는 변수
		int tmp, max;
		
		//기준점에 따라 루프의 형태가 달라질 수 있으나
        //제일 뒤나 제일 앞으로 정렬되는 갯수를 기준으로 생각해보자
		for(int i = n-1; i>0; i--) {
			max = i;
			
			 //최댓값 찾아서(max = i(맨끝값)으로 설정해두어서 j<i 까지 비교하면 됨)
			for(int j=0; j < i; j++) {
				if(arr[j] > arr[max]) {
					max = j;
				}
			}
			
			//맨 끝과 교환
			tmp = arr[i];
			arr[i] = arr[max];
			arr[max] = tmp;
			
		}
	}
}

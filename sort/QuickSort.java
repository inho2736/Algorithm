import java.io.*;
public class QuickSort {

	private static int[] arr = {5, 6, 2, 8, 7, 23, 4, 1};
	
	public static void main(String[] args) {
		
		quickSort(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	private static void quickSort(int [] arr, int left, int right) {
		
		//left right 해서 원소가 한개이하면 return
		if (left >= right) {
			return;
		}
		
		//partition -> pivot의 위치를 정해줌
		int pivot = partition(arr, left, right);
		
		// 피봇 기준 왼쪽과 오른쪽 다시 재귀로 sort
		quickSort(arr, left, pivot-1);
		quickSort(arr, pivot+1, right);
	}
	private static int partition(int [] arr, int left, int right) {
		
		//지금은 pivot을 배열의 맨 앞으로 지정
		//배열이 역순으로 정렬되어있을 경우 매우 비효율적임 -> 이때는 pivot을 중간값으로
		int pivot = arr[left];
		int i = left;
		int j = right;
		
		//i 와 j 가 겹치지 않을때만 명령어 실행
		while(i < j) {
			
			//j는 오른쪽에서부터 pivot보다 작거나 같은 값을 찾아냄
			// pivot보다 크면 계속이동
			while(arr[j] > pivot){
				j--;
			}
			
			//i 는 왼쪽에서부터 pivot보다 큰 값을 찾아냄
			//pivot보다 작거나 같으면 계속 이동
			
			//바로 위 while문에서 j가 이동했을 때 (i < j) 조건이 깨졌을 수도 있으므로 한번 더 검사
			while((i < j) && arr[i] <= pivot) {
				i++;
			}
			
			//i랑 j 자리바꾸기
			swap(arr, i, j);
		}
		
		//i랑 j만나면 그자리를 pivot자리(현재는 제일 왼쪽) 와 바꿈
		swap(arr, i, left);
		
		//그 i자리가 피봇이 위치할 최종자리이므로 return
		return i;
	}
	private static void swap(int [] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}

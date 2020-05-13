package another;
import java.io.*;
import java.util.*;
public class Boj11004_K번째수 {
	static int result = -1;
	static int k = -1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(arr, 0, n-1);
		for(int i=0; i<n; i++) {
			bw.write(arr[i] + " ");
		}
		bw.write(arr[k-1]+"");
		bw.flush();
		br.close();
		bw.close();
	}
	public static void quickSort(int [] arr, int left, int right) {
		if(left >= right) {
			return;
		}
		
		int pivot = partition(arr, left, right);
		if(pivot > k-1) {
			quickSort(arr, left, pivot-1);
		}
		else if(pivot < k-1) {
			quickSort(arr, pivot +1, right);
		}
		else {
			return;
		}
	}
	
	public static int partition(int [] arr, int left, int right) {
		///
		int mid = (left + right) / 2; 
	    swap(arr, left, mid);
		
		int pivot = arr[left];
		int i = left;
		int j = right;
		
		while(i<j) {
			while(arr[j] > pivot) {
				j--;
			}
			while(i < j && arr[i] <= pivot) {
				i++;
			}
			swap(arr, i, j);
		}
		swap(arr, i, left);
		return i;
	}
	
	public static void swap(int [] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}

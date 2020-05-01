package another;
import java.io.*;

public class Boj2750_수정렬하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int [n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int tmp;
		
		//버블정렬 사
		for(int i=0; i<n; i++) {
			for(int j=0; j < n - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}

}

package another;
import java.io.*;
import java.util.*;
public class Boj11650_좌표정렬하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int [n][2];
		String [] tmp = new String[2];
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tmp[0]);
			arr[i][1] = Integer.parseInt(tmp[1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int [] x, int [] y) {
				if(x[0] == y[0]) {
					return  Integer.compare(x[1], y[1]);
				}
				return Integer.compare(x[0], y[0]);
			}
		});
		for(int i=0; i<n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		br.close();
	}

}

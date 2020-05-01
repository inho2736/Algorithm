package another;
import java.io.*;
import java.util.*;
public class Boj10814_나이순정렬 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [][] st = new String [n][2];
		String [] tmp = new String [2];
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			st[i][0] = tmp[0];
			st[i][1] = tmp[1];
		}
		
		Arrays.sort(st, new Comparator<String[]>() {
			@Override
			public int compare(String [] x, String [] y) {
				return Integer.compare(Integer.parseInt(x[0]), Integer.parseInt(y[0]));
			}
		});
		for(int i=0; i<n; i++) {
			System.out.println(st[i][0] + " " + st[i][1]);
		}
	}

}

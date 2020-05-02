package another;
import java.io.*;
import java.util.*;
public class Boj10825_국영수 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [][] st = new String [n][4];
		String [] tmp = new String [4];
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			st[i][0] = tmp[0];
			st[i][1] = tmp[1];
			st[i][2] = tmp[2];
			st[i][3] = tmp[3];
		}
		
		Arrays.sort(st, new Comparator<String[]>() {
			@Override
			public int compare(String [] x, String [] y) {
				if(Integer.parseInt(x[1]) == Integer.parseInt(y[1])) {
					if(Integer.parseInt(x[2]) == Integer.parseInt(y[2])) {
						if(Integer.parseInt(x[3]) == Integer.parseInt(y[3])) {
							return x[0].compareTo(y[0]);
						}
						return Integer.compare(Integer.parseInt(y[3]), Integer.parseInt(x[3]));
					}
					return Integer.compare(Integer.parseInt(x[2]), Integer.parseInt(y[2]));
				}
				return Integer.compare(Integer.parseInt(y[1]), Integer.parseInt(x[1]));
			}
		});
		for(int i=0; i<n; i++) {
			System.out.println(st[i][0]);
		}
		br.close();
	}

}

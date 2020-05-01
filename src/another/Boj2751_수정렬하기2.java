package another;
import java.io.*;
import java.util.*;
public class Boj2751_수정렬하기2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			integerList.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(integerList);
		
		for(int i=0; i<n; i++) {
			System.out.println(integerList.get(i));
		}
	}

}

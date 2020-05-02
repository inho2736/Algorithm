package another;
import java.io.*;
import java.util.*;
public class Boj11652_카드 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		long max_key = 0;
		int max_value = 0;
		for(int i=0; i<n; i++) {
			
			//2^-62 ~ 2^62 니까 long형으로 받아야함.
			long key = Long.parseLong(br.readLine());
			int value = 1;
			
			//이미 한번 받은적 있는 key 이면
			if(map.containsKey(key)) {
				value = map.get(key)+1;
				map.put(key, value);
			}
			
			//처음받는 key 이면
			else {
				map.put(key, 1);
			}
			
			if(value > max_value) {
				max_value = value;
				max_key = key;
			}
			else if(value == max_value) {
				max_key = Math.min(key, max_key);
			}
		}
		System.out.println(max_key);
		br.close();
		bw.close();
	}

}

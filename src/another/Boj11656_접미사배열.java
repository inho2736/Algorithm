
package another;
import java.io.*;
import java.util.*;
public class Boj11656_접미사배열 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String st = br.readLine();
		String [] arr = new String[st.length()];
		for(int i=0; i<st.length(); i++) {
			arr[i] = st.substring(i);
		}
		
		Arrays.sort(arr);
		for(int i=0; i<st.length(); i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

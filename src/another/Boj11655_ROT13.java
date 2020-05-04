package another;
import java.io.*;
import java.util.*;
public class Boj11655_ROT13 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String st = br.readLine();
		
		for(int i=0; i<st.length(); i++) {
			char tmp = st.charAt(i);
			if (tmp >= 'a' && tmp <= 'z') {
				tmp += 13;
				if(tmp > 'z') {
					tmp -= 26;
				}
				System.out.print(tmp);
			}
			else if(tmp >= 'A' && tmp <= 'Z'){
				tmp += 13;
				if(tmp > 'Z') {
					tmp -= 26;
				}
				System.out.print(tmp);
			}
			else {
				System.out.print(tmp);
			}
		}
		br.close();
		bw.close();
	}

}

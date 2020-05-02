package another;
import java.io.*;
import java.util.*;
public class Boj10824_네수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String string1 = "";
		string1 += st.nextToken();
		string1 += st.nextToken();
		
		String string2 = "";
		string2 += st.nextToken();
		string2 += st.nextToken();
		
		System.out.println(Long.parseLong(string1)+ Long.parseLong(string2));
		br.close();
		bw.close();
	}

}

package another;
import java.io.*;
import java.util.*;
public class Boj10808_알파벳개수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int [] arr = new int [26];
		String st = br.readLine();
		for(int i=0; i<st.length(); i++) {
			arr[st.charAt(i) - 'a']++;
		}
		for(int i =0; i<26; i++) {
			System.out.print(arr[i] + " ");
		}
		br.close();
		bw.close();
	}

}

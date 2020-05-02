package another;
import java.io.*;
import java.util.*;
public class Boj10820_문자열분석 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int [] result = new int [4];
			String st = sc.nextLine();
			for(int i=0; i<st.length(); i++) {
				if(st.charAt(i) >= 'a' && st.charAt(i) <= 'z') {
					result[0]++;
				}
				else if(st.charAt(i) >= 'A' && st.charAt(i)<= 'Z') {
					result[1]++;
				}
				else if(st.charAt(i) >= '0' && st.charAt(i)<= '9') {
					result[2]++;
				}
				else if(st.charAt(i) == ' ') {
					result[3]++;
				}
			}
			for(int i=0; i<4; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}

}

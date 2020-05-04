package another;
import java.util.*;
import java.io.*;
public class Boj10430_나머지 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		bw.write((a+b)%c + "\n");
		bw.write(((a%c)+(b%c))%c + "\n");
		bw.write((a*b)%c + "\n");
		bw.write(((a%c)*(b%c))%c + "\n");		
		
		bw.flush();
		br.close();
		bw.close();
		
		
	}

}

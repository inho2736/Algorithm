import java.util.*;
import java.io.*;
class Boj2884{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int newH;
        int newM;
        int minusH = 0;
        if(m >= 45){
            newM = m - 45;
        }else{
            newM = m - 45 + 60;
            minusH = 1;
        }

        if(h - minusH < 0){
            newH = h - minusH + 24;
        }else{
            newH = h - minusH;
        }

        bw.write(newH + " " + newM + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
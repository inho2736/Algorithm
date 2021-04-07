package Algorithm.BruteForce;
import java.util.*;
import java.io.*;
class Boj2231{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int tmp = i + calculate(i);
            if( tmp == n ){
                min = Math.min(min, i);
            }
        }
        if(min == Integer.MAX_VALUE){
            bw.write(0 +"\n");
        }else{

            bw.write(min + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    public static int calculate(int num) {
        int result = 0;
        while(num > 0){
            result += num % 10;
            num /= 10;
        }
        return result; 
    }
}
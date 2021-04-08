package Algorithm.BackTracking;

import java.util.*;
import java.io.*;
class Boj15652{
    static int n;
    static int m;
    static BufferedWriter bw;
    static int [] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [m];
        dfs(0, 1);
        br.close();
        bw.flush();
        bw.close();
    }
    public static void dfs(int count, int start) throws IOException{
        if(count == m){
            for(int i: arr){
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=start; i<=n; i++){
            arr[count] = i;
            dfs(count+1, i);
        }
    }
}
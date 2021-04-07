package Algorithm.BackTracking;

import java.util.*;
import java.io.*;
class Boj15649{
    static boolean [] visit;
    static int n;
    static int m;
    static int [] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean [n+1];
        arr = new int [m];

        dfs(0, arr);
        
        br.close();
        bw.flush();
        bw.close();
    }
    public static void dfs(int count, int [] arr) throws IOException{
        if(count == m ){
            for(int i=0; i<m; i++){
                bw.write(arr[i]+ " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=1; i<n+1; i++){
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            arr[count] = i;
            dfs(count+1, arr);
            visit[i] = false;
            
        }
    }
}
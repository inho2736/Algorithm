package Algorithm.BackTracking;
import java.util.*;
import java.io.*;
class Boj15650 {
    static int n;
    static int m;
    static boolean [] visit;
    static int [] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean [n + 1];
        arr = new int [m + 1] ;

        dfs(1, arr);
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int count, int [] arr) throws IOException{ 
        if(count > m){
            for(int i=1; i<=m; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        int start = arr[count -1];
        
        for(int i = start + 1; i< n + 1; i++ ){
           
            arr[count] = i;
            dfs(count + 1, arr);
        }
    }
}
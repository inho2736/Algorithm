package Algorithm.BackTracking;
import java.util.*;
import java.io.*;
class Boj15651{
    static int n;
    static int m;
    static BufferedWriter bw;
    static int [] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st  = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [m];
        dfs(0, arr);
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int count, int [] arr) throws IOException{
        if(count == m){
            for(int i: arr){
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            arr[count] = i;
            dfs(count +1, arr);
        }
    }
}

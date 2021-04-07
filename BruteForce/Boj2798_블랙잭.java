package Algorithm.BruteForce;

import java.util.*;
import java.io.*;
class Boj2798{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr  = new int [n]; 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= m){
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        bw.write(max +"\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
}
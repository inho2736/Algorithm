package Algorithm.BinarySearch;

import java.util.*;
import java.io.*;
class boj1654{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int [] arr = new int [k];
        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long start = 1;
        long end = arr[arr.length-1] ;
        long mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(calculate(arr, mid) < n){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }       
        bw.write(end+"\n"); 
        
        br.close();
        bw.flush();
        bw.close();
    }

    public static long calculate(int [] arr, long length){
        long result = 0;
        for(int i: arr){
            result += i / length;
        }
        return result;
    }
}
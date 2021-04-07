package Algorithm.BinarySearch;

import java.util.*;
import java.io.*;
class Boj1920{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            bw.write(binarySearch(arr, Integer.parseInt(st.nextToken())) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    public static int binarySearch (int[] arr, int n){
        int start = 0;
        int end = arr.length -1;
        int mid = 0;

        while(start <= end){
            mid = (start + end) / 2;
            if(n == arr[mid]){
                return 1;
            }else{
                if(n < arr[mid]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return 0;
    }
}
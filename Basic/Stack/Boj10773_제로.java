package Algorithm.Basic.Stack;
import java.io.*;
import java.util.*;

class Boj10773{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack <Integer> stack = new Stack<Integer>();
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            if(k == 0){
                stack.pop();
            }else{
                stack.push(k);
            }
        }

        int result = 0;
        for(int i : stack){
            result += i;
        }
        bw.write(result+"\n");
        br.close();
        bw.flush();
        bw.close();

    }
}
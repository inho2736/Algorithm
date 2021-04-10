package Algorithm.Basic.Stack;
import java.util.*;

import java.io.*;
class boj10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Queue <Integer> queue = new LinkedList<Integer>();
        Stack <Integer> stack = new Stack<Integer>();

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer( br.readLine());
            switch(st.nextToken()){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        bw.write(-1+"\n");
                    }else{
                        bw.write(stack.pop()+"\n");
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                        bw.write(-1+"\n");
                    }else{
                        bw.write(stack.peek()+"\n");
                    }
                    break;
                case "size":
                    bw.write(stack.size()+"\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        bw.write(1+"\n");
                    }
                    else{
                        bw.write(0+"\n");
                    }
                    break;
                
            }

        }
        br.close();
        bw.flush();
        bw.close();
    }
}
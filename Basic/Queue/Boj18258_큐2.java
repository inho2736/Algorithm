package Algorithm.Basic.Queue;

import java.util.*;
import java.io.*;
class Boj18258{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> list = new LinkedList<Integer>();
        int testCase = Integer.parseInt(br.readLine());

        int backValue = -1;
        for(int i=0; i<testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch(cmd){
                case "push" :
                    int item = Integer.parseInt(st.nextToken());
                    list.add(item);
                    backValue = item;
                    break;
                case "front":
                    if(list.isEmpty()){
                        bw.write(-1+"\n");
                    }else{
                        bw.write(list.peek() + "\n");
                    }
                    break;
                case "back":
                    if(list.isEmpty()){
                        bw.write(-1+"\n");
                    }else{
                        bw.write(backValue + "\n");
                    }
                    break;
                case "size":
                    bw.write(list.size() + "\n");
                    break;
                case "empty":
                    if(list.isEmpty()){
                        bw.write(1 + "\n");
                    }else{
                        bw.write(0 + "\n");
                    }
                    break;
                case "pop":
                    if(list.isEmpty()){
                        bw.write(-1+"\n");
                    }else{
                        bw.write(list.poll()+"\n");
                    }
                    break;

            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

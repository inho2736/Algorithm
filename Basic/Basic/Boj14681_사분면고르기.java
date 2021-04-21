
import java.io.*;
class Boj14681{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        bw.write(decide(x, y)+"\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
    public static int decide(int x, int y){
        if(x > 0){
            if(y > 0){
                return 1;
            }
            else{
                return 4;
            }
        }else{
            if( y > 0){
                return 2;
            }
            else{
                return 3;
            }
        }
    }
}

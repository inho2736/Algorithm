package basic;
import java.util.Scanner;

public class num {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum=0;
        //1234 이 줄 통채로 문자열로 가져오기
        String num2 = sc.next();
        
        for (int i=0; i<num; i++) {
        	//문자열에서 charAt으로 하나씩 char로 가져오고 그 하나의 char를 다시 string으로 바꾸고 그걸 parseInt로 integer화
        	sum += Integer.parseInt(Character.toString(num2.charAt(i)));
        }        
        sc.close();
        System.out.println(sum);
    }

}

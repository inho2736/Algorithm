package basic;
import java.util.Scanner;

public class print {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        //다음 줄이 존재할 때
        while (sc.hasNextLine()) {
        		//그거 받아오고 바로 출력
            String input = sc.nextLine();
            System.out.println(input);
        }
        
        sc.close();
    }

}

package basic;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
         
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            inputs.add(input);
        }
        sc.close();
 
        for (int i = 0; i < inputs.size(); ++i) {
            System.out.println(inputs.get(i));
        }
	}

}

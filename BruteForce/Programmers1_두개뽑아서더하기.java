package Algorithm.BruteForce;
import java.util.*;
class Solution {
    static public void main(String[] args){
        int [] arr = {2,1,3,4,1};
        solution(arr);
    }
    static public int[] solution(int[] numbers) {
        int length = numbers.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
 
        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                int sum = numbers[i]+numbers[j];
                if(list.indexOf(sum) < 0){
                    list.add(sum);
                }
            }
        }
        
        int [] arr = new int [list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        
        return arr;
    }
    static public int[] solution2(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(x -> x).toArray();
    }
}
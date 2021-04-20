package Algorithm.Basic.Queue;

// 자료구조 쓰려면 있어야해
import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int count = 0;
        ArrayList<Integer> done = new ArrayList<>();
        int truckNum = 0;
        Queue<int []> bridge = new LinkedList<>();
        int currentWeight = 0;
        // 시간이 흐르고, 갱신하면 그게 하루!
        
        // 다리를 다 지난트럭이 첫 트럭수와 같으면 종료
        while(done.size() != truck_weights.length){
            // refresh(bridge, currentWeight);
            //트럭이 오르는 조건
            if(bridge.size() < bridge_length && currentWeight + truck_weights[truckNum] <= weight){
                bridge.add(new int [] {truckNum++, 0});
            }
            count++;
        }
        return count;
    }
    
    public void refresh(Queue<int []> bridge, int currentWeight, int bridge_length){
     
        // 
        while(true){
            int [] temp = bridge.peek();
            if(temp == null){
                break;
            }
            else if(temp[1] == bridge_length -1){
                currentWeight -= bridge.poll()[0];
            }else{
                // bridge.
            }
        }
       
    }
}
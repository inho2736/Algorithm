import java.util.*;

class dslkfj{
    public static void main(String[] args){
        int [] scoville = {1,1, 100};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i: scoville){
            heap.add(i);
        }

        while(heap.size() > 1){
            int food1 = heap.poll();

            if(food1 >= K){
                break;
            }
            int food2 = heap.poll();
            int newFood = food1 + food2 * 2;
            heap.add(newFood);
            answer++;
        }

        if(heap.size() <= 1 && heap.peek() < K){
            return -1;
        }
       
        return answer;
    }
    // public static int badSolution(int[] scoville, int K) {
    //     int answer = 0;
    //     PriorityQueue<Integer> small = new PriorityQueue<>();
    //     PriorityQueue<Integer> big = new PriorityQueue<>();
    //     for(int i: scoville){
    //         if(i>= K){
    //             big.add(i);
    //         }else{
    //             small.add(i);
    //         }
    //     }
        
    //     if(small.isEmpty()){
    //         return answer;
    //     }
    //     while(true){
    //         answer++;
    //         int a = small.poll();
    //         int b;
    //         if(small.isEmpty()){
    //             b = big.poll();
    //         }else{
    //             b = small.poll();
    //         }
    //         int newScoville = a + b * 2;
    //         if(newScoville >= K){
    //             big.add(newScoville);
    //         }else{
    //             small.add(newScoville);
    //         }
    //         if(small.isEmpty()){
    //             return answer;
    //         }
    //         if(small.size() + big.size() == 1){
    //             return -1;
    //         }
            
    //     }
    // }
}
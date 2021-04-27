import java.util.*;

class sdf {
    public static void main(String[] args) {
        int[][] board = new int[5][5];
        board[0] = new int[] { 0, 0, 0, 0, 0 };
        board[1] = new int[] { 0, 0, 1, 0, 3 };
        board[2] = new int[] { 0, 2, 5, 0, 1 };
        board[3] = new int[] { 4, 2, 4, 4, 2 };
        board[4] = new int[] { 3, 5, 1, 3, 1 };

        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
        System.out.println(solution(board, moves));

    }
    public int newSolution(int[][] board, int[] moves) {
        int count = 0;
        int n = board.length;
        Stack <Integer> bucket = new Stack<Integer>();
        
        for(int i: moves){
       
            for(int j=0; j < n; j++){
                if(board[j][i-1] != 0){
                    int item = board[j][i-1];
                    board[j][i-1] = 0;
                    if(!bucket.isEmpty() && bucket.peek() == item){
                        count++;
                        bucket.pop();
                    }else{
                        bucket.push(item);
                    }
                    break;
                }
            }
        }
        return count*2;
        
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        ArrayList<Stack<Integer>> map = new ArrayList<>();
        Stack<Integer> bucket = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            map.add(new Stack<Integer>());
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    map.get(j).push(board[i][j]);
                }
            }
        }
        // for(Stack<Integer> i: map){
        // while(!i.isEmpty()){
        // System.out.print(i.pop()+" ");
        // }
        // System.out.println();
        // }
        for (int i : moves) {
            int index = i - 1;
            if (map.get(index).isEmpty()) {
                continue;
            }
            int item = map.get(index).pop();
            if (!bucket.empty() && bucket.peek() == item) {
                answer++;
                bucket.pop();
            } else {
                bucket.push(item);
            }
        }

        return answer * 2;
    }

}


import java.util.*;
class Progw{
    public static void main(String[] args) {
        String [] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String [] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
        // System.out.println("aa" == "aa");
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> hm = new HashMap<>();
        for(String tmp: participant){
            hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
        }
        for(String tmp: completion){
            hm.replace(tmp, hm.get(tmp) - 1);
        }
        // int [] arr = hm.values().stream().mapToInt(x->x).toArray();
        // for( int i: arr){
        //     System.out.println(i);
        // }

        for(String i: hm.keySet()){
            if(hm.get(i) > 0){
                return i;
            }
        }
        
        return "";
    }

    // public static String solution(String[] participant, String[] completion) {
    //     Arrays.sort(participant);
    //     Arrays.sort(completion);
    //     for(int i=0; i<completion.length; i++){
    //         if(!participant[i].equals(completion[i])){
    //             return participant[i];
    //         }
    //     }
    //     return participant[participant.length-1];
    // }
}

package hash_algorithm.solution19;

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(String str:completion){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(String s: participant){
            if(map.getOrDefault(s,0) == 0)
                return s;
            map.put(s,map.get(s)-1);
        }
        return answer;
    }
}

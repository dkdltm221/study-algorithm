import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> result = new HashMap<>();
        
        for(String s:completion){
            result.put(s,result.getOrDefault(s,0)+1);
        }
        for(String s: participant){
            if(!result.containsKey(s)) return s;
            int num = result.get(s);
            if(num==0) return s;
            result.put(s,num-1);
        }
        return "";
    }
}
package simulation_algorithm.Solution63;

import java.util.*;
class Solution {

    public int solution(int[] topping) {
        HashSet<Integer> left = new HashSet<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        int answer =0;
        for(int i:topping){
            right.put(i,right.getOrDefault(i,0)+1);
        }
        for(int i=0;i<topping.length-1;i++){
            int cur = topping[i];
            left.add(cur);

            right.put(cur,right.get(cur)-1);
            if(right.get(cur)==0){
                right.remove(cur);
            }
            if(left.size() == right.size())
                answer++;
        }
        return answer;
    }
}
package greedy_algorithm.Solution81;

import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n:tangerine){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        for(int i:list){
            answer++;
            k-=i;
            if(k<=0)
                break;
        }

        return answer;
    }
}
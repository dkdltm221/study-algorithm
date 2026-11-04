package que_algorithm.solution16;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n =progresses.length;
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        int[] days = new int[n];
        for(int i =0;i<n;i++){
            days[i] = (int) Math.ceil((100-progresses[i])/(double)speeds[i]);
        }
        int maxday = days[0];
        int count =0;
        for(int i =0;i<n;i++){
            if(days[i]<=maxday){
                count++;
            }
            else{
                answer.add(count);
                count = 1;
                maxday = days[i];
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

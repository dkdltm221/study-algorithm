package greedy_algorithm.Solution80;

import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left =0;
        int right = people.length-1;
        for(;left<=right;right--){
            if(people[left]+people[right]<=limit){
                answer++;
                left++;
                continue;
            }

            answer++;
        }

        return answer;
    }
}

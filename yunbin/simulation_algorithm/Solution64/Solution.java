package simulation_algorithm.Solution64;

import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;

        for(int i=1;i<=sum;i++){
            if(sum%i==0){
                int num = sum/i;
                if (i >= num) {
                    if ((i - 2) * (num - 2) == yellow) {
                        return new int[]{i, num};
                    }
                }
            }
        }
        return new int[]{};
    }
}
package sort_algorithm.solution53;

import java.util.*;
class Solution {
    public long solution(long n) {
        String[] s = String.valueOf(n).split("");
        Arrays.sort(s,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(String st:s){
            sb.append(st);
        }
        return Long.parseLong(sb.toString());
    }
}
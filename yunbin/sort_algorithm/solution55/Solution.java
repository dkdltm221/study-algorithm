package sort_algorithm.solution55;

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> as = new ArrayList<>();
        for(int n:numbers){
            as.add(String.valueOf(n));
        }
        as.sort((o1,o2)->{
            int a = Integer.parseInt(o1+o2);
            int b = Integer.parseInt(o2+o1);
            return Integer.compare(b,a);
        });
        StringBuilder sb = new StringBuilder();
        for(String s: as){
            sb.append(s);
        }
        return sb.charAt(0)=='0' ? "0":sb.toString();
    }
}

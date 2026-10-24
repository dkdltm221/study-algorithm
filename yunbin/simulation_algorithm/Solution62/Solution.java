package simulation_algorithm.Solution62;

import java.util.*;
class Solution {
    public int[] solution(String s) {
        int zero =0;
        int num =0;
        while(!s.equals("1")){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0'){
                    zero++;
                }
            }
            s = s.replace("0","");
            s = Integer.toBinaryString(s.length());
            num++;
        }
        int[] answer = new int[] {num,zero};
        return answer;
    }
}
package que_algorithm.solution17;

import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        ArrayDeque<String> card1 = new ArrayDeque<>();
        ArrayDeque<String> card2 = new ArrayDeque<>();
        for(int i=0;i<cards1.length;i++){
            card1.addLast(cards1[i]);
        }
        for(int j=0;j<cards2.length;j++){
            card2.addLast(cards2[j]);
        }
        for(int i =0;i<goal.length;i++){
            if(!card1.isEmpty()&&card1.peekFirst().equals(goal[i])){
                card1.pollFirst();
            }else if(!card2.isEmpty()&&card2.peekFirst().equals(goal[i])){
                card2.pollFirst();
            }else{
                answer = "No";
            }
        }
        return answer;
    }
}

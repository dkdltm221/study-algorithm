package tree_algorithm.solution27;

import java.util.*;
class Solution {
    HashMap<String,String> reference = new HashMap<>();
    HashMap<String,Integer> total = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];


        for(int i=0;i<enroll.length;i++){
            reference.put(enroll[i],referral[i]);
            total.put(enroll[i],0);
        }
        for(int i=0;i<seller.length;i++){
            findMother(seller[i],amount[i]*100);
        }
        for(int i=0;i<enroll.length;i++){
            answer[i]=total.get(enroll[i]);
        }
        return answer;
    }

    public void findMother(String s,int amount){
        if(amount ==0) return;
        String st = reference.get(s);
        int am = amount/10;
        amount = amount - am;
        total.put(s,total.getOrDefault(s,0)+amount);
        if(!reference.get(s).equals("-"))
            findMother(st,am);
    }
}

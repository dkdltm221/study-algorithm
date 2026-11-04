package hash_algorithm.solution20;

import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = discount.length;
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i=0;i<want.length;i++){
            hashMap.put(want[i],number[i]);
        }
        A:for(int i =0;i<n;i++){
            HashMap<String,Integer> map = new HashMap<>(hashMap);
            for(int j =i;j<i+10 && i+10<=n ;j++){
                if(map.getOrDefault(discount[j],0)==0)
                    continue;
                map.put(discount[j],map.get(discount[j])-1);
            }
            for(String s : want){
                if(map.get(s)!=0)
                    continue A;
            }
            answer++;
        }
        return answer;
    }
}

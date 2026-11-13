import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int ni = nums.length/2;
        for(int n : nums){
            set.add(n);
        }
        if(ni<set.size()) return ni;
        return set.size();
        
    }
}
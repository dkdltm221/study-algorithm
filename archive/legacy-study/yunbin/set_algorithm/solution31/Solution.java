package set_algorithm.solution31;

import java.util.*;
import java.util.stream.*;
public class Solution {
    public int solution(int[] nums) {
        return Math.min((int)Arrays.stream(nums).distinct().count(),nums.length/2);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 1, 2, 3}));
    }

}

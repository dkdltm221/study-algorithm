package dp_algorithm.Solution68;

import java.util.Arrays;

public class Solution {
    //LIS
    private static int lis(int[] nums){
        int n= nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

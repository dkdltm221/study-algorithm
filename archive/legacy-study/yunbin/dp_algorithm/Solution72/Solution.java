package dp_algorithm.Solution72;

import java.util.*;
class Solution {

    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] n = triangle.clone();
        for(int i=1;i<n.length;i++){
            for(int j=0;j<n[i].length;j++){
                if(j==0){
                    n[i][0] = n[i][0]+n[i-1][0];

                }
                else if(j==n[i].length-1){
                    n[i][j] = n[i][j]+n[i-1][j-1];

                }
                else{
                    n[i][j] = n[i][j]+Math.max(n[i-1][j],n[i-1][j-1]);
                }
            }
        }
        int[] n1 = n[n.length-1].clone();
        return Arrays.stream(n1).max().getAsInt();
    }
}
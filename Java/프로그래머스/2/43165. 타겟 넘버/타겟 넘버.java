import java.util.*;
class Solution {
    private static int[] visited;
    private static int[] num;
    private static int answer;
    private static void dfs(int cnt, int current, int target) {
        if (cnt == num.length) {
            if (current == target)
                answer++;
            return;
        }

        dfs(cnt + 1, current + num[cnt], target);
        dfs(cnt + 1, current - num[cnt], target);
    }
    public int solution(int[] numbers, int target) {
        answer = 0;
        num = numbers.clone();
        visited = new int[numbers.length];
        dfs(0,0,target);
        return answer;
    }
}
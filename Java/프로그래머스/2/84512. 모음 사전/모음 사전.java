import java.util.*;
class Solution {
    private static String[] vowels = {"A", "E", "I", "O", "U"};
    private static int count;
    private static int answer;
    private static void dfs(String current, String target) {
        if(answer!=0) return;
        
        // 2. 현재 문자열이 비어 있지 않으면 count 증가
        if(!current.isEmpty())
            count++;
        // 3. current와 target이 같으면?
        if(current.equals(target))
            answer=count;
        if(current.length()==5)
            return;
        for (int i = 0; i < 5; i++) {
            // 4. 다음 모음을 붙여서 DFS 호출
            dfs(current+vowels[i],target);
        }
    }
    public int solution(String word) {
        count =0;
        answer =0;
        dfs("",word);
        return answer;
    }
}
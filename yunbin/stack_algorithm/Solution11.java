import java.util.ArrayDeque;
class Solution11
{
    public int solution(String s)
    {
        ArrayDeque<Character> que = new ArrayDeque<>();
        int answer = 0;
        for(char c:s.toCharArray()){
            if(que.isEmpty()){
                que.push(c);
                continue;
            }
            if(que.peek()==c){
                que.pop();
                continue;
            }
            que.push(c);
        }
        if(que.isEmpty())
            answer =1;

        return answer;
    }
}
//해당 문제는 음.. 레벨 1수준정도 였던거같다 좀 쉬웠음
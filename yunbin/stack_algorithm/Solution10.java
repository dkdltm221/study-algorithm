//내가 푼문제
public class Solution10 {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> que = new LinkedList<>();
        for(char ch : s.toCharArray()){
            que.offer(ch);
        }
        for(int i=0;i<s.length();i++){
            Stack<Character> st = new Stack<>();
            boolean check = true;
            for(char c: que){
                if(c=='{' || c=='(' || c=='['){
                    st.push(c);
                }else{
                    if(st.isEmpty()){
                        check =false;
                        break;
                    }
                    char top = st.pop();
                    if(c==')'&& top!='(' || c=='}'&& top!='{' || c==']'&& top!='['){
                        check = false;
                        break;
                    }

                }

            }
            if(st.isEmpty() && check) answer++;
            que.offer(que.poll());
        }

        return answer;
    }


    /*
    해당 책의 내용 해쉬 맵을 사용해서 문자열 비교하는것이 인상적이었음
    문자를 하나하나 비교하며 스택을 사용했으나 추가로 check메서드를 사용해야하는것이
    거슬렸다 좋은방법이 있을거같았다
    해당 코드에서 A: for문을 사용하는데 해당 문법을 처음 접한 나로선 매우 신선한 경험이었다.
     */

    public static int solution1(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')'.'(');
        map.put('}'.'{');
        map.put(']'.'[');
        int n = s.length();
        s+= s;
        int answer = 0;

        A:for(int i=0;i<n;i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for(int j=0;j<i+n;j++){
                char c = s.charAt(j);
                if(!map.containsKey(c)){
                    stack.push(c);
                }
                else{
                    if(stack.isEmpty()|| !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            if(stack.isEmpty())
                answer++;
        }
        return answer;
    }
}
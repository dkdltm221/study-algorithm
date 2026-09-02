package stack_algorithm.solution12;

import java.util.ArrayDeque;

/*
해당 알고리즘 O(n)을 목표로 계산해봤는데 35분동안 생각하다가 도저히 답이안나와 포기하고 O(n^2)으로
40분안에 푸는거 성공 흠 while문 사용을하면 O(n^2(나온다고 생각한게 패착인듯..
또한 스택안에 인덱스 번호를 넣는걸 생각못한게 큼  해당 버전으로 다시한번 풀어보자
 */

public class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<size;j++){
                answer[i]++;
                if (prices[j] < prices[i]) break;
            }
        }

        return answer;
    }
    public int[] solution1(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i=1;i<size;i++){
            while(!stack.isEmpty() && prices[i]<prices[stack.peek()]){
                int j = stack.pop();
                answer[j] = i-j;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = size-1-j;
        }
        return answer;
    }
}

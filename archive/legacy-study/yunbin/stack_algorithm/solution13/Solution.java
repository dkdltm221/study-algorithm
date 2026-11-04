package stack_algorithm.solution13;

import java.util.Stack;

//스택 배열있는지 몰랐다,, 더빠르게 푸는걸;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board[0].length;
        Stack<Integer> basket = new Stack<>();
        A: for(int i:moves){
            int j=0;
            while(j<size && board[j][i-1]==0){
                j++;
            }
            if(j>=size) continue A;
            if(!basket.isEmpty()  && basket.peek()==board[j][i-1]){
                board[j][i-1]=0;
                basket.pop();
                answer+=2;
                continue A;
            }

            basket.push(board[j][i-1]);
            board[j][i-1]=0;
        }

        return answer;
    }
}

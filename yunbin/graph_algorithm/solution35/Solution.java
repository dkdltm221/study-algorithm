package graph_algorithm.solution35;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    private static ArrayList<Integer>[] adjList;

    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph,int start, int n){
        adjList = new ArrayList[n+1];
        for(int i = 0; i < adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        answer = new ArrayList<>();
        for(int[] edge : graph){
            adjList[edge[0]].add(edge[1]);
        }
        bfs(start);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            answer.add(now);
            for(int next : adjList[now]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

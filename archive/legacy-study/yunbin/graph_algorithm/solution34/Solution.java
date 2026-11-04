package graph_algorithm.solution34;

import java.util.ArrayList;

public class Solution {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static int[] solution(int[][] graph,int start,int n){
        adjList=new ArrayList[n+1];
        visited=new boolean[n+1];
        answer=new ArrayList<>();
        for(int i=0;i<adjList.length;i++){
            adjList[i]=new ArrayList<>();
        }
        for(int[] edge:graph){
            adjList[edge[0]].add(edge[1]);
        }
        dfs(start);
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
    public static void dfs(int i){
        visited[i]=true;
        answer.add(i);
        for(int j:adjList[i]){
            if(!visited[j]){
                dfs(j);
            }
        }
    }


}

package graph_algorithm.solution36;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    private static class Node{
        int dest,cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    public static int[] solution(int[][] graph,int start,int n){
        ArrayList<Node>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : graph){
            adj[edge[0]].add(new Node(edge[1], edge[2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cost, o1.cost));
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.dest]){
                continue;
            }
            visited[cur.dest] = true;
            for(Node next : adj[cur.dest]){
                if(dist[cur.dest] > next.cost+cur.cost){
                    dist[cur.dest] = next.cost+cur.cost;
                    pq.add(new Node(cur.dest, dist[cur.dest]));
                }
            }
        }
        return dist;
    }
}

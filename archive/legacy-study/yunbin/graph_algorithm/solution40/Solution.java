package graph_algorithm.solution40;

import java.util.*;
class Solution {
    public class Node{
        int dist;
        int cost;
        public Node(int d,int c){
            this.dist = d;
            this.cost = c;
        }
    }


    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Node>[] adjList = new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            adjList[i]=new ArrayList<>();
        }
        for(int[] adj:road){
            adjList[adj[0]].add(new Node(adj[1],adj[2]));
            adjList[adj[1]].add(new Node(adj[0],adj[2]));
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] =0;
        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        que.add(new Node(1,0));

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(dist[cur.dist]<cur.cost)
                continue;

            for(Node next : adjList[cur.dist]){
                if(dist[next.dist]> next.cost+cur.cost){
                    dist[next.dist] = next.cost+cur.cost;
                    que.add(new Node(next.dist,dist[next.dist]));
                }
            }


        }
        for(int i=1;i<dist.length;i++){
            System.out.println(i+":"+dist[i]);
            if(dist[i]<=K)

                answer++;
        }


        return answer;
    }
}
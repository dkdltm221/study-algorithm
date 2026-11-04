package set_algorithm.solution33;

import java.util.*;
public class Solution {
    private static int[] parent;

    private static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    private static void union(int x, int y){
        int root1 = parent[x];
        int root2 = parent[y];
        parent[root2] = root1;
    }
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs,(o1,o2)->Integer.compare(o1[2],o2[2]));
        parent = new int[n];
        int answer =0;
        int edges = 0;
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge : costs){
            if(edges == n-1)
                break;
            if(find(edge[0])!=find(edge[1])){
                union(edge[0],edge[1]);
                answer+= edge[2];
                edges++;
            }

        }
        return answer;
    }
}
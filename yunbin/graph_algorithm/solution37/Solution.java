package graph_algorithm.solution37;

import java.util.*;
class Solution {
    private static int[] x = {0,0,-1,1};
    private static int[] y = {-1,1,0,0};
    private static class Node{
        int r,c;
        public Node(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] map = new int[n][m];

        ArrayDeque<Node> que = new ArrayDeque<>();
        que.addLast(new Node(0,0));
        map[0][0] =1;

        while(!que.isEmpty()){
            Node cur = que.pollFirst();

            for(int k=0;k<4;k++){
                int dx = cur.r+x[k];
                int dy = cur.c+y[k];
                if(dx<0 || dx>=n || dy <0 || dy>=m)
                    continue;
                if(maps[dx][dy]==0)
                    continue;
                if(map[dx][dy]!=0)
                    continue;
                map[dx][dy]=map[cur.r][cur.c]+1;
                que.addLast(new Node(dx,dy));
            }
        }
        if(map[n-1][m-1]==0)
            return -1;
        return map[n-1][m-1];

    }


}
package graph_algorithm.solution41;

import java.util.*;
class Solution {
    public class Node{
        int r,c,cost,corner;
        public Node(int r,int c,int cost,int corner){
            this.r=r; this.c=c; this.cost=cost; this.corner=corner;
        }
    }
    int[] dr = {0,0,-1,1};
    int[] dc = {-1,1,0,0};
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] map = new int[n][n][3];
        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        map[0][0][0] = 1;
        que.add(new Node(0,0,1,0));

        while(!que.isEmpty()){
            Node cur = que.poll();


            for(int k=0;k<4;k++){
                int dx = cur.r + dr[k];
                int dy = cur.c + dc[k];
                if(dx<0 || dx>=n || dy<0 || dy>=n) continue;
                if(board[dx][dy]==1) continue;

                boolean isVertical = (k==2 || k==3);
                int newCorner = isVertical ? 2 : 1;

                int addCost;
                if(cur.corner != 0 && cur.corner != newCorner) addCost = 600;
                else addCost = 100;

                int newCost = map[cur.r][cur.c][cur.corner] + addCost;

                if(map[dx][dy][newCorner]==0 || newCost < map[dx][dy][newCorner]){
                    map[dx][dy][newCorner] = newCost;
                    que.add(new Node(dx,dy,newCost,newCorner));
                }
            }
        }

        int best = Integer.MAX_VALUE;
        for(int c=1;c<=2;c++){
            if(map[n-1][n-1][c] != 0)
                best = Math.min(best, map[n-1][n-1][c]);
        }
        return best - 1;
    }
}
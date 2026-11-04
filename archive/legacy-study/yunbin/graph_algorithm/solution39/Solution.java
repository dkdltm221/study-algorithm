package graph_algorithm.solution39;

import java.util.*;
class Solution {
    private static int[] dx ={0,0,1,-1};
    private static int[] dy = {-1,1,0,0};
    public static class Node{
        int r,c;
        public Node(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public static int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        boolean trek = false;
        boolean trek2 = false;
        int[][] map = new int[n][m];
        int[][] map2 = new int[n][m];
        int s1=0,s2=0,s3=0,s4=0;
        outer:
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j)=='S'){
                    s1=i;
                    s2=j;
                    break outer;
                }
            }
        }
        ArrayDeque<Node> que = new ArrayDeque<>();
        que.addLast(new Node(s1,s2));
        while(!que.isEmpty()){
            Node cur = que.pollFirst();
            if(maps[cur.r].charAt(cur.c)=='L'){
                s1=cur.r;
                s2=cur.c;
                trek2=true;
                break;
            }
            for(int k=0;k<4;k++){
                int dr = cur.r+dx[k];
                int dc = cur.c + dy[k];
                if(dr<0 || dr>=n || dc <0 || dc>=m)
                    continue;

                if(map[dr][dc] == 0 && maps[dr].charAt(dc) != 'X'){
                    map[dr][dc] = map[cur.r][cur.c]+1;
                    que.addLast(new Node(dr,dc));
                }
            }
        }
        if(!trek2)
            return -1;
        que.clear();
        que.addLast(new Node(s1,s2));
        while(!que.isEmpty()){
            Node cur = que.pollFirst();
            if(maps[cur.r].charAt(cur.c)=='E'){
                s3=cur.r;
                s4=cur.c;
                trek = true;
                break;
            }
            for(int k=0;k<4;k++){
                int dr = cur.r+dx[k];
                int dc = cur.c + dy[k];
                if(dr<0 || dr>=n || dc <0 || dc>=m)
                    continue;

                if(map2[dr][dc] == 0 && maps[dr].charAt(dc) != 'X'){
                    map2[dr][dc] = map2[cur.r][cur.c]+1;
                    que.addLast(new Node(dr,dc));
                }
            }
        }
        if(trek)
            return map[s1][s2]+map2[s3][s4];
        return -1;
    }
}
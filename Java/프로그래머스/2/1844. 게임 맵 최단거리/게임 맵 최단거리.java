import java.util.*;
class Solution {
    private static int[] dr = {0,0,-1,1};
    private static int[] dc = {-1,1,0,0};
    private static int[][] visited;
    class Node{
        int r,c,cnt;
        public Node(int r,int c,int cnt){
            this.r =r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m];
        ArrayDeque<Node> que = new ArrayDeque<>();
        visited[0][0] =1;
        que.addLast(new Node(0,0,1));
        while(!que.isEmpty()){
            Node cur = que.pollFirst();
            if(cur.r == n-1 && cur.c == m-1){
                answer = cur.cnt;
                return answer;
            }
            for(int k=0;k<4;k++){
                int nr = dr[k]+cur.r;
                int nc = dc[k]+cur.c;
           
                if(nr<0 || nr>=n || nc <0 || nc>=m) continue;
                if(visited[nr][nc]!=0) continue;
                if(maps[nr][nc] == 0) continue;
               
                visited[nr][nc] =1;
                que.addLast(new Node(nr,nc,cur.cnt+1));
            }
        }
        return answer;
    }
}
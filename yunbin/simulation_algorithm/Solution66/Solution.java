package simulation_algorithm.Solution66;
//다음부턴 왠만해선 해쉬맵 쓰자;;
class Solution {
    private static int[] dr = {0,0,-1,1};
    private static int[] dc = {-1,1,0,0};
    private static int x,y;
    private static int maxX,maxY;
    private static void moveMent(String s){
        int dx=0;
        int dy=0;
        switch(s){
            case "left":
                dx = x+dr[2];
                dy = y;
                break;
            case "right":
                dx = x+dr[3];
                dy = y;
                break;
            case "up":
                dy = y+dc[1];
                dx = x;
                break;
            case "down":
                dy = y+dc[0];
                dx = x;
                break;
        }
        if(Math.abs(dx)<=maxX && Math.abs(dy)<=maxY){
            x=dx;
            y=dy;
        }
        return;


    }
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        maxX = board[0]/2;
        maxY=board[1]/2;
        x=0;
        y=0;
        for(String s:keyinput){
            moveMent(s);
        }
        return new int[]{x,y};
    }
}
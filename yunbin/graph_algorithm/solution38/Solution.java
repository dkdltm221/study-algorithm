package graph_algorithm.solution38;

class Solution {
    private static boolean[] visited;
    private static int[][]computer;
    private static void dfs(int x){
        visited[x] = true;
        for(int i=0;i<computer[0].length;i++){
            if(computer[x][i]==1 && !visited[i]){
                dfs(i);

            }
        }
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i])
                continue;
            dfs(i);
            answer++;
        }
        return answer;
    }
    //{1,1,0,0,0},{1,1,0,0,0},{0,0,1,1,0},{0,0,1,1,0}{0,0,0,0,1}
}
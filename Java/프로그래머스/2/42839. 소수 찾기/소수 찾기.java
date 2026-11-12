import java.util.*;
class Solution {
    private static String[] map;
    private static int[] visited;
    private static HashSet<Integer> cnt;
    
    private static void dfs(String n){
        
        if (!n.isEmpty()){
            if(n.charAt(0)=='0')
                return;
            int number = Integer.parseInt(n);
            if (isPrime(number)){
                cnt.add(number);
            }
        }
        for(int i=0;i<map.length;i++){
            if(visited[i]!=0) continue;
            
            visited[i]=1;
            dfs(map[i]+n);
            dfs(n+map[i]);
            visited[i]=0;
            
        }
    }
    
    private static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i*i <=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public int solution(String numbers) {
        cnt = new HashSet<>();
        //dps 로 해야될거같다.
        //백트래킹이 필요해보인다.
        //앞뒤 방문은 그중간에 해제하는 방식으로 진행하면되지않을까? 수는 작다 출력을 보며해보자
        map = numbers.split("");
        visited = new int[numbers.length()+1];
        dfs("");
        return cnt.size();
    }
}
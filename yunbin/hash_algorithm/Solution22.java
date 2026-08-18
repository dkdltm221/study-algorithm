import java.util.*;
// 진짜 대가리 터지는줄;;; 노가다 성으로 풀순있는데 어떻게 효율적으로 짤가 고민하다보니 시간이 훌쩍간다.;;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        HashMap<String,ArrayList<int[]>> valu = new HashMap<>();
        ArrayDeque<String> que = new ArrayDeque<>();
        for(int i=0;i<genres.length;i++){
            hashMap.put(genres[i],hashMap.getOrDefault(genres[i],0)+plays[i]);
            if(!valu.containsKey(genres[i])){
                valu.put(genres[i],new ArrayList<>());
            }
            valu.get(genres[i]).add(new int[]{i, plays[i]});
        }

        String[] gen = Arrays
                .stream(genres)
                .distinct()
                .toArray(String[]::new);
        Arrays.sort(gen,(a,b) -> hashMap.get(b)-hashMap.get(a));

        for(String s:gen){
            ArrayList<int[]> songs = valu.get(s);
            songs.sort((a,b) -> b[1]-a[1]);

            for(int i=0; i<songs.size() && i<2; i++){
                answer.add(songs.get(i)[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
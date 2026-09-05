package sort_algorithm.solution52;

import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings,(o1,o2)->o1.charAt(n)==o2.charAt(n)?o1.compareTo(o2):Character.compare(o1.charAt(n),o2.charAt(n)));

        return strings;
    }
}

//
//class Solution {
//    public String[] solution(String[] strings, int n) {
//        String[] answer = new String[strings.length];
//        PriorityQueue<String> que = new PriorityQueue<>((o1,o2)->o1.charAt(n)==o2.charAt(n) ? o1.compareTo(o2) : Character.compare(o1.charAt(n),o2.charAt(n)));
//        for(String s: strings){
//            que.add(s);
//        }
//        for(int i=0;i<strings.length;i++){
//            answer[i] = que.poll();
//        }
//        return answer;
//    }
//}
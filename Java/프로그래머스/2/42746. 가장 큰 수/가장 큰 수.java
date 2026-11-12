import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> as = new ArrayList<>();
        for(int n:numbers){
            as.add(String.valueOf(n));
        }
        as.sort((o1,o2)->{
            int a = Integer.parseInt(o1+o2);
            int b = Integer.parseInt(o2+o1);
            return Integer.compare(b,a);
        });
        StringBuilder sb = new StringBuilder();
        for(String s:as){
            sb.append(s);
        }
        return sb.charAt(0)=='0' ? "0":sb.toString();
    }
}
/*
1 2 3 4
1234,1324,1342,1243,1423,1432
2134,2143,2314,2341,2413,2431
24개 
*/
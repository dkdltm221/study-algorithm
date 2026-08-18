import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        int n = record.length;
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String,String> hashMap = new HashMap<>();
        String[][] str = new String[n][3];
        for(int i=0;i<n;i++){
            str[i] = record[i].split(" ");
            if(str[i].length >2)
                hashMap.put(str[i][1],str[i][2]);
        }
        for(int i=0;i<n;i++){
            if(str[i][0].equals("Enter")){
                answer.add(hashMap.get(str[i][1])+"님이 들어왔습니다.");
                continue;
            }else if(str[i][0].equals("Leave")){
                answer.add(hashMap.get(str[i][1])+"님이 나갔습니다.");
                continue;
            }
        }

        return answer.toArray(new String[0]);
    }
}
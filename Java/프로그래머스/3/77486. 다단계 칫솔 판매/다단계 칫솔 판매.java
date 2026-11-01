import java.util.*;

class Solution {
    private static HashMap<String,Integer> price;
    private static HashMap<String,String> tree;
    
    
    public static void dfs(int amount,String child){
        if(amount*0.1<1){
            price.put(child,price.get(child)+amount);
            return;
        }
        int num = amount / 10;
        price.put(child, price.get(child) + amount - num);
        if(tree.get(child).equals("-")){
            return;
        }
        dfs(num, tree.get(child));
        
        
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        price = new HashMap<>();
        tree = new HashMap<>();
        for(int i=0;i<enroll.length;i++){
            price.put(enroll[i],0);
            tree.put(enroll[i],referral[i]);
        }
        for(int i=0;i<seller.length;i++){
            dfs(amount[i]*100,seller[i]);
        }
        for(int i=0;i<enroll.length;i++){
            answer[i] = price.get(enroll[i]);
        }
        
        return answer;
    }
}
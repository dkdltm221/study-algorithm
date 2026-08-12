//효율성 통과못함 위치옮기는게 너무어려운듯;;

import java.util.Stack;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        char[] ch = new char[n];
        char c;
        int num=k;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            ch[i]='O';
        }
        for(String s: cmd){
            int nx=0;
            int i =1;
            if(s.length()>1){
                String[] str = s.split(" ");
                c = str[0].charAt(0);
                nx = Integer.parseInt(str[1]);
            }else
                c=s.charAt(0);
            switch(c){
                case 'U':
                    while(i<=nx){
                        if(num>0 && ch[num-1]=='X'){
                            num -= 1;
                        }else if(num==0)
                            break;
                        else {
                            num -=1;
                            i++;
                        }

                    }
                    break;
                case 'D':
                    while(i<=nx){
                        if(num+1<n && ch[num+1]=='X'){
                            num += 1;
                        }else if(num==n-1)
                            break;
                        else{
                            num+=1;
                            i++;
                        }
                    }

                    break;
                case 'C':
                    ch[num] = 'X';
                    stack.push(num);

                    int origin = num;

                    while (num < n-1 && ch[num] != 'O') {
                        num += 1;
                    }
                    if (ch[num] != 'O') {
                        num = origin;
                        while (num > 0 && ch[num] != 'O') {
                            num -= 1;
                        }
                    }
                    break;
                case 'Z':
                    if(!stack.isEmpty()){
                        ch[stack.pop()]='O';
                    }
                    break;
            }



        }
        return String.valueOf(ch);
    }
}
/*
1       1 (2) (부활)
2 --    2
3       3
4 -- c  4 (1)
5       5
6       6
7       7 (3) (4부활)
8       8

*/
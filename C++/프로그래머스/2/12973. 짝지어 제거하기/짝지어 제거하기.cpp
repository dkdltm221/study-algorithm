#include <iostream>
#include<string>
#include<stack>
using namespace std;

// 반복n 연속된 문자열 제거 
// 모든 문자열이 사라질때까지
// 정지조건: 한번의 n반복때 사라진 문자열이 없을경우

// 효율성 테스트에 실패했다 음 O(n)으로 풀어야할듯?
// 생각해보니 스택을 사용하면 O(n)이될거같다.

int solution(string s)
{
    int answer = -1;
    stack<char> st;
    for(char c:s){
        if(st.empty()) st.push(c);
        else if(st.top()==c) st.pop();
        else st.push(c);
    }
    if(st.empty())return 1;
    return 0;
  
}
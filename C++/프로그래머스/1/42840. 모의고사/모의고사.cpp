#include <string>
#include <vector>
#include <algorithm>
using namespace std;



vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int number[3] = {0,0,0};
    int Max=0;
    int first[5] = {1,2,3,4,5};
    int second [8] = {2,1,2,3,2,4,2,5};
    int third [10] = {3,3,1,1,2,2,4,4,5,5};
    for(int i=0;i<answers.size();i++){
        if(first[i%5] == answers[i]) number[0]++;
        if(second[i%8] == answers[i]) number[1]++;
        if(third[i%10] == answers[i]) number[2]++;
    }
    Max = max({number[0],number[1],number[2]});
    for(int i=0;i<3;i++){
        if(Max==number[i])
            answer.push_back(i+1);
    }
    
    
    return answer;
}
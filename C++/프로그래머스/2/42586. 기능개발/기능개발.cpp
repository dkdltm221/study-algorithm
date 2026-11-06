#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int index = 0;
    int count =1;
    int day =(100-progresses[0])%speeds[0] == 0 ? ((100-progresses[0])/speeds[0]) : ((100-progresses[0])/speeds[0])+1;
    for(int i=1;i<progresses.size();i++){
        int n = (100-progresses[i]);
        int less = n%speeds[i] == 0 ? (n/speeds[i]) : (n/speeds[i])+1;
        if(less>day){
            day = less;
            answer.push_back(count);
            count=1;
            cout << day << endl;
            continue;
        }
        count++;
    }
    answer.push_back(count);
    return answer;
}
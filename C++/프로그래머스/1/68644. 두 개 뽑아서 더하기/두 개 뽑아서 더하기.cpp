#include <string>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

vector<int> solution(vector<int> numbers) {

    set<int> result;
    for(int i=0;i<numbers.size();i++){
        for(int j=i+1;j<numbers.size();j++){
            result.insert(numbers[i] + numbers[j]);
        }
    }
    
    vector<int> answer(result.begin(), result.end());
    return answer;
}
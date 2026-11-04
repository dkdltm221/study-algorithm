#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<int,double>> result;

    for (int i = 1; i <= N; i++) {
        int n = 0;
        int m = 0;

        for (int j = 0; j < stages.size(); j++) {
            if (stages[j] >= i) n++;
            if (stages[j] == i) m++;
        }
        double failRate = (n == 0) ? 0.0 : (double)m / n;
        result.push_back({i,failRate});
    }

    

    sort(result.begin(), result.end(), [](const auto& a, const auto& b) {
        if (a.second == b.second)
            return a.first < b.first;

        return a.second > b.second;
    });

    for (const auto& p : result) {
        answer.push_back(p.first);
    }

    return answer;
}
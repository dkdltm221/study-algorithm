#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    map<int, double> result;

    for (int i = 1; i <= N; i++) {
        int n = 0;
        int m = 0;

        for (int j = 0; j < stages.size(); j++) {
            if (stages[j] >= i) n++;
            if (stages[j] == i) m++;
        }

        result[i] = (n == 0) ? 0.0 : (double)m / n;
    }

    vector<pair<int, double>> v(result.begin(), result.end());

    sort(v.begin(), v.end(), [](const auto& a, const auto& b) {
        if (a.second == b.second)
            return a.first < b.first;

        return a.second > b.second;
    });

    for (const auto& p : v) {
        answer.push_back(p.first);
    }

    return answer;
}
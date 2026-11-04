#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    answer.resize(arr1.size(),vector<int>(arr2[0].size(),0));
    
    for(int i=0;i<arr1.size();i++){
        for(int j=0;j<arr2[0].size();j++){
            int num =0;
            for(int k=0;k<arr1[0].size();k++){
                num+= arr1[i][k]*arr2[k][j];
            }
            answer[i][j] = num;
            
            
        }
    }
    
    
/*
2 3 2    5 4 3   22 22 11
4 2 4    2 4 1   36 28 18
3 1 4    3 1 1

00 01 02 
00 10 20 == 00

00 01 02
01 11 21 == 01

00 01 02
02 12 22 == 02




*/
    return answer;
}
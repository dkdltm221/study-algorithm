package simulation_algorithm.Solution65;

import java.util.*;

public class Solution {
    public int solution(int n) {
        return Integer.toBinaryString(n).replace("0","").length();
    }
}
package greedy_algorithm.Solution78;

import java.util.Arrays;

public class Solution {
    private static class Item{
        int value,weight;
        double valuePreWeight;
        public Item(int value, int weight, double valuePreWeight){
            this.value = value;
            this.weight = weight;
            this.valuePreWeight = valuePreWeight;
        }
    }
    private static double solution(int[][] items,int weight_limit){
        Item[] item = new Item[items.length];
        for(int i=0;i<items.length;i++){
            item[i] = new Item(items[i][1],items[i][0],(double)items[i][1]/items[i][0]);
        }

        Arrays.sort(item,(o1,o2)-> Double.compare(o2.valuePreWeight,o1.valuePreWeight));
        double totalValue = 0;
        int remainingWeight = weight_limit;
        for(Item i: item){
            if(i.weight <= remainingWeight){
                totalValue += i.value;
                remainingWeight -= i.weight;
            }
            else{
                double fraction = (double)remainingWeight / i.weight;
                totalValue += fraction*i.value;
                break;
            }
        }
        return totalValue;
    }
}

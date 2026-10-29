class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] max = new int[2];
        
        for(int i=0;i<sizes.length;i++){
            if(max[0]<sizes[i][0])
                max[0] = sizes[i][0];
            if(max[1]<sizes[i][1])
                max[1] = sizes[i][1];
        }
        int maxN = max[0]>max[1] ? 0:1;
        int minN = max[0]>max[1] ? 1:0;
        max[minN]=0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][maxN]<sizes[i][minN]){
                int temp = sizes[i][maxN];
                sizes[i][maxN] = sizes[i][minN];
                sizes[i][minN] = temp;
            }
            if(max[minN]<sizes[i][minN])
                max[minN] = sizes[i][minN];
        }
        
        return max[maxN]*max[minN];
    }
}
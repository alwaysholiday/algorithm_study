package src.test.cuPlay.two;

public class Solution {
    public int solution(int n) {
        int[] upperCount = new int[448];
        int sum = 0;
        for(int i=1 ; i<upperCount.length ; i++){
            sum += i;
            upperCount[i] = sum;
        }

        int count = 0;
        for(int heightIndex = 0 ; ; heightIndex++){
            int bottomCount = n - upperCount[heightIndex];
            if(bottomCount <= heightIndex){
                break;
            }
            count = Math.max(count, bottomCount * (heightIndex + 1));
        }
        return count;
    }
}

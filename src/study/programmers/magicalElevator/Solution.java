package src.study.programmers.magicalElevator;

public class Solution {
    public int solution(int storey) {
        int count = 0;
        while(storey > 0){
            int currentNum = storey % 10;
            storey = storey / 10;
            if(currentNum > 5){
                count += (10 - currentNum);
                storey++;
            } else if(currentNum < 5) {
                count += currentNum;
            } else {
                int nextNumber = storey % 10;
                if(nextNumber < 5){
                    count += currentNum;
                } else {
                    count += (10 - currentNum);
                    storey++;
                }
            }
        }
        return count;
    }
}

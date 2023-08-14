package src.study.leetcode.countAndSay;

public class Solution {
    public String countAndSay(int n) {
        return calculateCountAndSay(n);
    }

    private String calculateCountAndSay(int n){
        if(n==1){
            return "1";
        }
        String beforeStr = calculateCountAndSay(n-1);
        StringBuilder strBuilder = new StringBuilder();

        int currentCalculateNum = -1;
        int currentCalculateCount = 0;
        for(int i=0 ; i<beforeStr.length() ; i++){
            int currentNum = Character.getNumericValue(beforeStr.charAt(i));
            if(currentCalculateNum == -1){
                currentCalculateNum = currentNum;
                currentCalculateCount = 1;
                continue;
            }

            if(currentCalculateNum != currentNum){
                strBuilder.append(currentCalculateCount);
                strBuilder.append(currentCalculateNum);
                currentCalculateNum = currentNum;
                currentCalculateCount = 1;
            } else {
                currentCalculateCount++;
            }
        }
        if(currentCalculateNum != -1){
            strBuilder.append(currentCalculateCount);
            strBuilder.append(currentCalculateNum);
        }
        return strBuilder.toString();
    }
}

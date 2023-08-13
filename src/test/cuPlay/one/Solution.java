package src.test.cuPlay.one;

import java.util.Stack;

public class Solution {
    public int solution(String number) {
        Stack<Integer> numStack = new Stack<>();
        int count=0;
        for(int i=0 ; i<number.length() ; i++){
            int currentNum = Character.getNumericValue(number.charAt(i));
            if(numStack.size() == i){
                pushNumber(currentNum, numStack);
                count++;
            } else {
                int latestNum = numStack.peek();
                if(latestNum != currentNum){
                    numStack.pop();
                    count++;
                    pushNumber(currentNum, numStack);
                    count++;
                }
            }
        }

        if(numStack.size() > number.length()){
            count += (numStack.size() - number.length());
        }
        return count;
    }

    private void pushNumber(int num, Stack<Integer> numStack){
        if(num == 0){
            numStack.push(0);
        } else if(num == 9){
            numStack.push(9);
            numStack.push(0);
        } else {
            numStack.push(num);
            numStack.push(num + 1);
        }
    }
}

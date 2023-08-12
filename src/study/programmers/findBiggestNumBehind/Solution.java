package src.study.programmers.findBiggestNumBehind;

import java.util.Stack;

public class Solution {
    class Item{
        int number;
        int index;

        public Item(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    public int[] solution(int[] numbers) {
        Stack<Item> itemStack = new Stack<>();
        int[] answer = new int[numbers.length];
        for(int i=0 ; i<numbers.length ; i++){
            while(true){
                if(itemStack.empty()){
                    itemStack.push(new Item(numbers[i], i));
                    break;
                }

                Item currentItem = itemStack.peek();
                if(numbers[i] > currentItem.number){
                    Item toDeleteItem = itemStack.pop();
                    answer[toDeleteItem.index] = numbers[i];
                } else {
                    itemStack.push(new Item(numbers[i], i));
                    break;
                }
            }
        }
        while(itemStack.empty() == false){
            Item currentItem = itemStack.pop();
            answer[currentItem.index] = -1;
        }

        return answer;
    }
}

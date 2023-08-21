package src.test.cuPlay.seven;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> sumTwoArr(List<Integer> firstList, List<Integer> secondList){
        int numSum = parseList(firstList) + parseList(secondList);
        List<Integer> reversedList = new ArrayList<>();
        while(numSum != 0){
            int temp = numSum % 10;
            reversedList.add(temp);
            numSum /= 10;
        }

        List<Integer> result = new ArrayList<>(reversedList.size());
        for(int i=reversedList.size() - 1 ; i >= 0 ; i--){
            result.add(reversedList.get(i));
        }
        return result;
    }

    private int parseList(List<Integer> itemList){
        int result = 0;
        for(Integer item : itemList){
            result = result * 10 + item;
        }
        return result;
    }
}

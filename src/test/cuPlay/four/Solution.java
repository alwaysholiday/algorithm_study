package src.test.cuPlay.four;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Solution {
    public List<Integer> createRandomArr(int length){
        boolean[] checkArr = new boolean[length + 1];
        List<Integer> resultList = new LinkedList<>();
        while(resultList.size() < length){
            int currentNum = new Random().nextInt(length) + 1;
            if(checkArr[currentNum] == false){
                checkArr[currentNum] = true;
                resultList.add(currentNum);
            }
        }
        return resultList;
    }
}

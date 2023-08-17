package src.test.mol;

import java.util.ArrayList;
import java.util.List;

public class One {
    int[] solution(int[] a) {
        int[] result = new int[10];
        int maxCount = 0;
        for(int item : a){
            int copy = item;
            while(copy != 0){
                int divided = copy % 10;
                copy = copy / 10;
                result[divided]++;
                maxCount = Math.max(maxCount, result[divided]);
            }
        }
        List<Integer> summary = new ArrayList<>();
        for(int i=0 ; i<result.length ; i++){
            if(result[i] == maxCount){
                summary.add(i);
            }
        }
        int[] temp = new int[summary.size()];
        int index = 0;
        for(Integer item : summary){
            temp[index++] = item;
        }
        return temp;
    }
}

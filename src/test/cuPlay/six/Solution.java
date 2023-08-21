package src.test.cuPlay.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
        input : [1,4][2,6][8,10][15,18]
        output : [1,6][8,10][15,18]

        input : [1,4][0,3][0,8]
        output : [0,8]
    */

    class IntervalPair implements Comparable<IntervalPair>{
        int start;
        int end;

        public IntervalPair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(IntervalPair o) {
            if(this.start < o.start){
                return -1;
            } else if(this.start > o.start){
                return 1;
            } else {
                return Integer.compare(this.end, o.end);
            }
        }
    }

    public int[][] mergeArr(int[][] inputs){
        IntervalPair[] pairArr = new IntervalPair[inputs.length];
        for(int i=0 ; i< inputs.length ;i++){
            int[] currentLine = inputs[i];
            pairArr[i] = new IntervalPair(currentLine[0], currentLine[1]);
        }

        Arrays.sort(pairArr);
        List<IntervalPair> pairList = new ArrayList<>(inputs.length);
        for(IntervalPair item : pairArr){
            if(pairList.isEmpty()){
                pairList.add(item);
                continue;
            }

            IntervalPair lastPair = pairList.get(pairList.size() - 1);
            if(lastPair.end < item.start){
                pairList.add(item);
            } else {
                if(lastPair.end < item.end){
                    lastPair.end = item.end;
                }
            }
        }

        int[][] result = new int[pairArr.length][2];
        for(int i=0 ; i< pairArr.length ; i++){
            IntervalPair currentPair = pairList.get(i);
            result[i][0] = currentPair.start;
            result[i][1] = currentPair.end;
        }
        return result;
    }
}

package src.study.programmers.splitNumberCards;

public class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int aResult = canDivide(arrayA, arrayB);
        int bResult = canDivide(arrayB, arrayA);
        if(aResult == -1 && bResult == -1){
            return 0;
        }
        return Math.max(aResult, bResult);
    }

    private int canDivide(int[] targetArr, int[] findGdcArr){
        int gdc = findGdc(findGdcArr);
        if(gdc == 1){
            return -1;
        }
        for (int j : targetArr) {
            int dividedNum = j % gdc;
            if (dividedNum == 0) {
                return -1;
            }
        }
        return gdc;
    }

    private int findGdc(int[] inputArr){
        if(inputArr.length < 2){
            return -1;
        }
        int gdcResult = gdc(inputArr[0], inputArr[1]);
        for(int i=2 ; i < inputArr.length ; i++){
            gdcResult = gdc(gdcResult, inputArr[i]);
        }
        return gdcResult;
    }

    private int gdc(int a, int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b != 0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}

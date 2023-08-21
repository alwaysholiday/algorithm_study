package src.test.cuPlay.five;

public class Solution {
    // input 3[a2[c]]ef
    // output accaccaccef
    int currentIndex = 0;
    public String parseStr(String inputStr){
        StringBuilder builder = new StringBuilder();
        for(; currentIndex<inputStr.length() ; currentIndex++){
            char currentChar = inputStr.charAt(currentIndex);
            if('0' <= currentChar && currentChar <= '9'){
                builder.append(createSubStr(inputStr));
            } else {
                builder.append(currentChar);
            }
        }
        return builder.toString();
    }

    private String createSubStr(String inputStr){
        int loopCount = 0;
        for( ; currentIndex<inputStr.length() ; currentIndex++){
            char currentChar = inputStr.charAt(currentIndex);
            if(currentChar == '['){
                currentIndex++;
                break;
            }
            loopCount = (loopCount * 10) + Character.getNumericValue(currentChar);
        }

        StringBuilder tempBuilder = new StringBuilder();
        for( ; currentIndex < inputStr.length() ; currentIndex++){
            char currentChar = inputStr.charAt(currentIndex);
            if('0' <= currentChar && currentChar <= '9'){
                tempBuilder.append(createSubStr(inputStr));
            } else if(currentChar == ']'){
                break;
            } else {
                tempBuilder.append(currentChar);
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for(int i=0 ; i<loopCount ; i++){
            resultBuilder.append(tempBuilder);
        }
        return resultBuilder.toString();
    }
}

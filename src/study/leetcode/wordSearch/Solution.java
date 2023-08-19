package src.study.leetcode.wordSearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        boolean[][] touched = new boolean[height][width];
        for(int i=0 ; i<height ; i++){
            for(int j=0 ; j<width ; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean findResult = canFindWord(board, word, i, j, touched, 0);
                    if(findResult){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean canFindWord(char[][] board, String word, int x, int y, boolean[][] touched, int depth){
        int height = board.length;
        int width = board[0].length;
        if(x < 0 || x >= height){
            return false;
        }
        if(y < 0 || y >= width){
            return false;
        }
        if(touched[x][y]){
            return false;
        }
        char currentFindChar = word.charAt(depth);
        if(board[x][y] != currentFindChar){
            return false;
        }
        if((word.length()-1) == depth){
            return true;
        }
        touched[x][y] = true;
        boolean upResult = canFindWord(board, word, x-1, y, touched, depth+1);
        boolean downResult = canFindWord(board, word, x+1, y, touched, depth+1);
        boolean leftResult = canFindWord(board, word, x, y-1, touched, depth+1);
        boolean rightResult = canFindWord(board, word, x, y+1, touched, depth+1);
        touched[x][y] = false;
        return upResult || downResult || leftResult || rightResult;
    }
}

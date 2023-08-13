package src.test.cuPlay.three;

public class main {
    public static void main(String[] args) {
//        String[] inputs = new String[]{
//                "0000000111",
//                "1110010110",
//                "1110111000",
//                "0000000111",
//        };

//        String[] inputs = new String[]{
//                "111",
//                "000",
//                "000",
//                "110",
//        };

//        String[] inputs = new String[]{
//                "1000011",
//                "1111000",
//                "0000000",
//                "1101111",
//        };

        String[] inputs = new String[]{
                "1000011",
                "1111000",
                "0000000",
                "1101111",
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(inputs));
    }
}

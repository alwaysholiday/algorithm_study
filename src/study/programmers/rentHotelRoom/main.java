package src.study.programmers.rentHotelRoom;

public class main {
    public static void main(String[] args) {
//        String[][] inputs = new String[][]{
//                {"15:00", "17:00"},
//                {"16:40", "18:20"},
//                {"14:20", "15:20"},
//                {"14:10", "19:20"},
//                {"18:20", "21:20"},
//        };

//        String[][] inputs = new String[][]{
//                {"09:10", "10:10"},
//                {"10:20", "12:20"},
//        };

//        String[][] inputs = new String[][]{
//                {"10:20", "12:30"},
//                {"10:20", "12:30"},
//                {"10:20", "12:30"},
//        };

        String[][] inputs = new String[][]{
                {"23:30", "23:55"},
                {"10:20", "12:50"},
                {"10:20", "12:50"},
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(inputs));
    }
}

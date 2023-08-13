package src.study.programmers.rentHotelRoom;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Solution {
    public int solution(String[][] book_time) {
        LocalDateTime[] startTimeArr = new LocalDateTime[book_time.length];
        LocalDateTime[] endTimeArr = new LocalDateTime[book_time.length];
        for(int i=0 ; i< book_time.length ; i++){
            String[] startEndTime = book_time[i];
            startTimeArr[i] = parseTime(startEndTime[0], false);
            endTimeArr[i] = parseTime(startEndTime[1], true);
        }
        Arrays.sort(startTimeArr);
        Arrays.sort(endTimeArr);

        int endIndex = 0;
        int result = 0;
        for(int i=0 ; i < startTimeArr.length ; i++){
            int startIndex = i + 1;
            for(; endIndex < endTimeArr.length ; endIndex++){
                if(endTimeArr[endIndex].isAfter(startTimeArr[i])){
                    break;
                }
            }
            result = Math.max(result, startIndex - endIndex);
        }

        return result;
    }

    LocalDateTime parseTime(String timeStr, boolean isEnd){
        String[] strSplit = timeStr.split(":");
        int year = 2000;
        int month = 1;
        int day = 1;
        int minute = Integer.parseInt(strSplit[1]);
        int hour = Integer.parseInt(strSplit[0]);
        if(isEnd){
            minute = minute + 10;
            if(minute >= 60){
                minute = minute - 60;
                hour++;
            }
            if(hour >= 24){
                hour = hour - 24;
                day++;
            }
        }
        return LocalDateTime.of(year, month, day, hour, minute);
    }
}

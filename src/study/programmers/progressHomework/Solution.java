package src.study.programmers.progressHomework;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    class Homework implements Comparable<Homework>{
        String name;
        LocalTime startTime;
        LocalTime endTime;
        long duration;

        public Homework(String name, String time, String durationStr) {
            String[] timeSplit = time.split(":");
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = Integer.parseInt(timeSplit[1]);
            this.duration = Integer.parseInt(durationStr);
            this.name = name;
            this.startTime = LocalTime.of(hour, minute);
            this.endTime = startTime.plusMinutes(this.duration);
        }

        @Override
        public int compareTo(Homework o) {
            if(this.startTime.isBefore(o.startTime)){
                return -1;
            } else if(this.startTime.isAfter(o.startTime)){
                return 1;
            } else {
                return 0;
            }
        }

        public boolean isThisFinish(Homework o){
            return !this.endTime.isAfter(o.startTime);
        }
    }

    public String[] solution(String[][] plans) {
        Homework[] homeworkArr = new Homework[plans.length];
        for(int i=0 ; i< plans.length ; i++){
            String[] plan = plans[i];
            homeworkArr[i] = new Homework(plan[0], plan[1], plan[2]);
        }
        Arrays.sort(homeworkArr);

        Stack<Homework> homeworkStack = new Stack<>();
        List<String> resultList = new ArrayList<>(homeworkArr.length);
        for (Homework currentHomework : homeworkArr) {
            if(homeworkStack.empty()){
                homeworkStack.push(currentHomework);
                continue;
            }

            Homework latestHomework = homeworkStack.peek();
            long between = Duration.between(latestHomework.startTime, currentHomework.startTime).toMinutes();

            while (homeworkStack.empty() == false && between > 0) {
                Homework beforeHomework = homeworkStack.pop();
                between -= beforeHomework.duration;
                if(between < 0){
                    beforeHomework.duration = Math.abs(between);
                    homeworkStack.push(beforeHomework);
                } else {
                    resultList.add(beforeHomework.name);
                }
            }
            homeworkStack.push(currentHomework);
        }
        while(homeworkStack.empty() == false){
            Homework currentHomework = homeworkStack.pop();
            resultList.add(currentHomework.name);
        }
        return resultList.toArray(new String[0]);
    }
}

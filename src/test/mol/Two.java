package src.test.mol;

import java.util.LinkedList;
import java.util.Queue;

public class Two {
    class Process{
        int currentNum;
        int count;

        public Process(int currentNum, int count) {
            this.currentNum = currentNum;
            this.count = count;
        }
    }

    boolean[] touch = new boolean[1000000];
    Queue<Process> processQueue = new LinkedList<>();
    int count = -1;

    public int solution(int x, int y, int n) {
        if(x==y){
            return 0;
        }
        processQueue.add(new Process(x, 0));
        while(processQueue.isEmpty() == false){
            Process tempProcess = processQueue.poll();
            doSomething(addFunc(tempProcess.currentNum, n), tempProcess.count, y);
            doSomething(multiTwo(tempProcess.currentNum), tempProcess.count, y);
            doSomething(multiThree(tempProcess.currentNum), tempProcess.count, y);
            if(count != -1){
                break;
            }
        }

        return count;
    }

    private int addFunc(int x, int n){
        return x + n;
    }

    private int multiTwo(int x){
        return x * 2;
    }

    private int multiThree(int x){
        return x * 3;
    }

    private void doSomething(int result, int currentCount, int y){
        if(result == y){
            count = currentCount + 1;
        } else if (result < y){
            if(touch[result] == false){
                touch[result] = true;
                processQueue.add(new Process(result, currentCount + 1));
            }
        }
    }
}

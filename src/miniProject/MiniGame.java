package com.multi.h_1;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MiniGame {
    private int count = 0;
    private int timeLeft = 30;

    public void miniGame() {
        Random r = new Random();
        int x = 0;
        int y = 0;
        int operation = 0;
        int sum = 0;

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("시간이 초과되었습니다!");
                System.out.println("최종 점수: " + count);
                System.exit(0); // 시간이 초과되면 프로그램 종료
            }
        };

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
                System.out.println("남은 시간: " + timeLeft + "초");
            }
        }, 1000, 1000);

        timer.schedule(task, timeLeft* 1000);

        while(true) {
            x = r.nextInt(10) + 1;
            y = r.nextInt(10) + 1;
            operation = r.nextInt(4);

            switch (operation) {
                case 0:
                    sum = x + y;
                    System.out.println(x + "+" + y);
                    break;
                case 1:
                    sum = x - y;
                    System.out.println(x + "-" + y);
                    break;
                case 2:
                    sum = x * y;
                    System.out.println(x + "*" + y);
                    break;
                case 3:
                    if (x % y == 0) { // 나눗셈 결과가 정수인 경우에만 계속
                        sum = x / y;
                        System.out.println(x + "/" + y);
                    } else {
                        continue;
                    }
                    break;
                default:
                    break;
            }

            Scanner s = new Scanner(System.in);
            int result = s.nextInt();

            if (result == sum) {
                System.out.println("정답입니다.");
                count++;
            } else {
                System.out.println("오답입니다.");
            }

            System.out.println("점수 : " + count + "점");

        }
    }
}

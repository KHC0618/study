package com.multi.h_1;

import javax.swing.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game extends JFrame {
    Scanner sc;
    private Date start;
    private Date now;
    private int spentTime;
    static int time;
    private int i;

    JLabel count, problem;

    private int setNum() {
        while (true) {
            try {
                sc = new Scanner(System.in);
                int num = sc.nextInt();
                if (spentTime >= 30) {
                    return 0;
                }
                return num;
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }

    }

    public int Meun(int i, int item) {//i은 레벨


        int soc = 0;
        switch (i) {
            case 1:
                soc = level(10, 2);
                break;
            case 2:
                soc = level(10, 4);
                break;
            case 3:
                soc = level(50, 4);
                break;
        }
        soc = soc * i;
        switch (item) {

            case 1:
                soc = soc * 2;
                ;
                break;
            case 2:
                soc = level(10, 4);
            case 3:
                soc = level(100, 4);
        }


        return soc;
    }

    private class GameT extends Thread {
        private Date start;
        private Date now;


        @Override
        public void run() {
            start = new Date();

            while (spentTime < 30) {

                now = new Date();
                spentTime = (int) (now.getTime() - start.getTime()) / 1000;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("강제 종료합니다...");
                }
            }
            System.out.println("");
            System.out.println("종료");
            i = 30;
            System.exit(0);
        }
    }

    private int level(int round, int operations) {
        Random r = new Random();
        GameT game = new GameT();
        ;
        int sum = 0;
        int sum1;
        int count = 0;
        game.start();
        for (i = 0; i < 30; i++) {

            int x = r.nextInt(round) + 1;
            int y = r.nextInt(round) + 1;
            int mu = r.nextInt(operations) + 1;
            String str = null;

            switch (mu) {

                case 1:
                    sum = x + y;
                    str = x + "+" + y + "=";
                    System.out.print(str);
                    break;
                case 2:
                    sum = x - y;
                    str = x + "-" + y + "=";
                    System.out.print(str);
                    break;
                case 3:
                    sum = x * y;
                    str = x + "*" + y + "=";
                    System.out.print(str);
                    break;
                case 4:
                    while (true) {
                        if (x % y == 0) {
                            break;
                        }
                        x = r.nextInt(round) + 1;
                        y = r.nextInt(round) + 1;
                    }
                    sum = x / y;
                    str = x + "/" + y + "=";
                    System.out.print(str);

                    break;

            }


            while (true) {

                try {
                    sum1 = setNum();
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 숫자를 입력해주세요.");

                }
                System.out.print(str);
            }

            if (i == 30) {
                System.out.println("시간 초과 입니다");
            } else if (sum == sum1) {
                System.out.println("정답입니다");
                count++;
            } else {

                System.out.println("오답입니다");
                System.out.println("정답은 " + sum + "입니다");
            }
            time = 0;
            System.out.println();

        }
        game.interrupt();
        return count;
    }
}
